package baekjoon.graphSearch.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RobotInAMaze {
    private static int R, C;
    private static String[][] maze;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int result;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();;

        for (int t = 0; t < T; t++) {
            R = sc.nextInt();
            C = sc.nextInt();
            sc.nextLine();

            maze = new String[R][C];
            for (int i = 0; i < R; i++) {
                maze[i] = sc.nextLine().split("");
            }

            result = 225;
            visited = new boolean[R][C];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (maze[i][j].equals("S")) {
                        bfs(new Node(i, j, 0));
                    }
                }
            }

            if (result == 225) {
                System.out.println("No Exit");
            } else {
                System.out.println("Shortest Path: " + result);
            }
        }
    }

    private static void bfs(Node start) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.x][start.y] = true;

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;

            if (maze[x][y].equals("G")) {
                result = Math.min(result,  cur.cnt);
            }

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (!visited[nx][ny] && !maze[nx][ny].equals("X")) {
                        queue.offer(new Node(nx, ny, cur.cnt + 1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

    }

    private static class Node {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
