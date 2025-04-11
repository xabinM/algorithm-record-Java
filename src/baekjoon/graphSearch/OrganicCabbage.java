package baekjoon.graphSearch;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class OrganicCabbage {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int N, M;
    private static int[][] graph;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            M = sc.nextInt();   // 가로
            N = sc.nextInt();   // 세로
            int K = sc.nextInt();   // 배추 개수

            graph = new int[N][M];
            for (int i = 0; i < K; i++) {
                int y = sc.nextInt();
                int x = sc.nextInt();
                graph[x][y] = 1;
            }
            visited = new boolean[N][M];
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == 1 && !visited[i][j]){
                        bfs(new Node(i, j));
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void bfs(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            visited[x][y] = true;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    if (graph[nx][ny] == 1) {
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
        }
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
