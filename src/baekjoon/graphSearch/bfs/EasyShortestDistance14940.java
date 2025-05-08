package baekjoon.graphSearch.bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class EasyShortestDistance14940 {
    private static int n, m;
    private static int[][] graph;
    private static int[][] dist;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n][m];
        dist = new int[n][m];
        int startX = 0;
        int startY = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
                dist[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    dist[i][j] = 0;
                }
            }
        }

        visited = new boolean[n][m];

        bfs(new Node(startX, startY));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(Node start) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.x][start.y] = true;
        dist[start.x][start.y] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && graph[nx][ny] == 1) {
                        dist[nx][ny] = dist[x][y] + 1;
                        visited[nx][ny] = true;
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
        }
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
