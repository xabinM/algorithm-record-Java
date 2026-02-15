package baekjoon.graphSearch;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BestGrass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();

        String[][] graph = new String[R][C];

        for (int i = 0; i < R; i++) {
            graph[i] = sc.nextLine().split("");
        }

        boolean[][] visited = new boolean[R][C];

        int result = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {

                if (graph[i][j].equals("#") && !visited[i][j]) {
                    result += 1;
                    bfs(new Node(i, j), R, C, graph, visited);
                }
            }
        }

        System.out.println(result);
    }

    public static void bfs(Node node, int R, int C, String[][] graph, boolean[][] visited) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node.x][node.y] = true;

        while (!queue.isEmpty()){
            Node cur = queue.poll();

            int x = cur.x;
            int y = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C && graph[nx][ny].equals("#") && !visited[nx][ny]) {
                    queue.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
