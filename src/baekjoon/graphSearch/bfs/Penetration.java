package baekjoon.graphSearch.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Penetration {
    private static int M, N;
    private static int[][] graph;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        sc.nextLine();

        graph = new int[M][N];
        for (int i = 0; i < M; i++) {
            graph[i] = Arrays.stream(sc.nextLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < N; i++) {
            if (graph[0][i] == 0) {
                boolean result = bfs(new Node(0, i), new boolean[M][N]);

                if (result) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.print("NO");
    }

    private static boolean bfs(Node node, boolean[][] visited) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node.x][node.y] = true;

        while (!queue.isEmpty()) {
            Node start = queue.poll();
            int x = start.x;
            int y = start.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && graph[nx][ny] == 0) {
                        queue.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++){
            if (visited[M - 1][i]) {
                return true;
            }
        }
        return false;
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
