package baekjoon.graphSearch;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class WarBattle1303 {
    private static int N, M;
    private static String[][] graph;
    private static boolean[][]  visited;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        graph = new String[M][N];
        for (int i = 0; i < M; i++) {
            graph[i] = sc.nextLine().split("");
        }

        visited = new boolean[M][N];
        int B = 0;
        int W = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int result = bfs(new Node(i, j));
                    if (graph[i][j].equals("W")) {
                        W += (int) Math.pow(result, 2);
                    } else {
                        B += (int) Math.pow(result, 2);
                    }
                }
            }
        }

        System.out.println(W + " " + B);
    }

    private static int bfs(Node start) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.x][start.y] = true;

        int cnt = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int x = node.x;
            int y = node.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny]) {
                    if (graph[start.x][start.y].equals(graph[nx][ny])) {
                        queue.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                        cnt ++;
                    }
                }
            }
        }
        return cnt;
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
