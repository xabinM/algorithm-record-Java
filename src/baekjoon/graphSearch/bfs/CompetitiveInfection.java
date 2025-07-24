package baekjoon.graphSearch.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class CompetitiveInfection {
    private static int N, K, S, X, Y;
    private static int[][] graph;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static boolean[][] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        sc.nextLine();

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        S = sc.nextInt();
        X = sc.nextInt();
        Y = sc.nextInt();

        visited = new boolean[N][N];

        for (int t = 0; t < S; t++){
            Deque<Node> queue = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] != 0 && !visited[i][j]) {
                        queue.offer(new Node(i, j));
                        visited[i][j] = true;
                    }
                }
            }
            bfs(queue);
        }

        System.out.println(graph[X - 1][Y - 1]);
    }

    private static void bfs(Deque<Node> queue) {

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            int x = cur.x;
            int y = cur.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (graph[nx][ny] == 0) {
                    graph[nx][ny] = graph[x][y];
                } else if (graph[nx][ny] != 0 && !visited[nx][ny]){
                    graph[nx][ny] = Math.min(graph[nx][ny], graph[x][y]);
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
