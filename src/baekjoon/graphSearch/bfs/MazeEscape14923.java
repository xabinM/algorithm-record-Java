package baekjoon.graphSearch.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class MazeEscape14923 {
    private static int N, M, Hx, Hy, Ex, Ey;
    private static int[][] maze;
    private static boolean[][][] visited;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        Hx = sc.nextInt() - 1;
        Hy = sc.nextInt() - 1;
        Ex = sc.nextInt() - 1;
        Ey = sc.nextInt() - 1;
        sc.nextLine();

        maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            maze[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        visited = new boolean[N][M][2];

        System.out.println(bfs(new Node(Hx, Hy, 0, 0)));
    }

    private static int bfs(Node start) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.x][start.y][0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;

            if (Ex == x && Ey == y) {
                return cur.dist;
            }

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (maze[nx][ny] == 0 && !visited[nx][ny][cur.broken]) {
                        visited[nx][ny][cur.broken] = true;
                        queue.offer(new Node(nx, ny, cur.broken, cur.dist + 1));
                    } else if (maze[nx][ny] == 1 && cur.broken == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.offer(new Node(nx, ny, 1, cur.dist + 1));
                    }
                }
            }
        }
        return -1;
    }

    private static class Node {
        int x, y, broken, dist;

        public Node(int x, int y, int broken, int dist) {
            this.x = x;
            this.y = y;
            this.broken = broken;
            this.dist = dist;
        }
    }
}
