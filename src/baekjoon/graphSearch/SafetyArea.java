package baekjoon.graphSearch;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SafetyArea {
    private static int N;
    private static int[][] graph;
    private static int maxHeight;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1 ,1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
                maxHeight = Math.max(maxHeight, graph[i][j]);
            }
        }

        int result = Integer.MIN_VALUE;

        for (int curHeight = 0; curHeight < maxHeight; curHeight++) {
            boolean[][] visited = new boolean[N][N];
            int cnt = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (graph[x][y] > curHeight && !visited[x][y]) {
                        bfs(new Node(x, y), visited, curHeight);
                        cnt++;
                    }
                }
            }
            result = Math.max(result, cnt);
        }

        System.out.println(result);
    }

    private static void bfs(Node start, boolean[][] visited, int curHeight) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny <N && !visited[nx][ny]) {
                    if (graph[nx][ny] > curHeight){
                        queue.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
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
