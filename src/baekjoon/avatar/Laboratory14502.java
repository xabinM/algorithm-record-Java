package baekjoon.avatar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Laboratory14502 {
    private static int N, M;
    private static int[][] graph;
    private static int maxSafeArea = 0;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        dfs(0);

        System.out.println(maxSafeArea);
    }

    // 벽 3개 세우기
    private static void dfs(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    dfs(cnt + 1);
                    graph[i][j] = 0;
                }
            }
        }
    }

    // 바이러스 퍼뜨리기
    private static void bfs() {
        int[][] temp = new int[N][M];
        Queue<Node> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = graph[i][j];
                if (temp[i][j] == 2) {
                    queue.offer(new Node(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (temp[nx][ny] == 0) {
                        temp[nx][ny] = 2;
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
        }

        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) {
                    safeArea++;
                }
            }
        }

        maxSafeArea = Math.max(maxSafeArea, safeArea);
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
