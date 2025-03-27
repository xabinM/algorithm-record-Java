package SSAFY.bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class cheeseThief {
    private static int N;
    private static int[][] graph;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();

            graph = new int[N][N];
            int maxCheese = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    graph[i][j] = sc.nextInt();
                    maxCheese = Math.max(maxCheese, graph[i][j]);
                }
            }

            int maxLoafCnt = 0;
            for (int day = 0; day < maxCheese; day++) {
                maxLoafCnt = Math.max(maxLoafCnt, bfs(day));
            }

            System.out.println("#" + t + " " + maxLoafCnt);
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int bfs(int day) {
        int loafCount = 0;
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && graph[i][j] > day) {
                    Queue<Node> queue = new ArrayDeque<>();

                    queue.offer(new Node(i, j));
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        Node cur = queue.poll();
                        int x = cur.x;
                        int y = cur.y;

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && graph[nx][ny] > day) {
                                queue.offer(new Node(nx, ny));
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    loafCount++;
                }
            }
        }
        return loafCount;
    }
}
