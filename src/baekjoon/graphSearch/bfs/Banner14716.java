package baekjoon.graphSearch.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Banner14716 {
    private static int M, N;
    private static int[][] graph;
    private static boolean[][] visited;
    private static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        sc.nextLine();

        graph = new int[M][N];
        for (int i = 0; i < M; i++) {
            graph[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    bfs(new Node(i, j));
                }
            }
        }

        System.out.println(cnt);
    }

    private static void bfs(Node start) {
        int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
        int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;

            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && graph[nx][ny] == 1) {
                        queue.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        cnt++;
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
