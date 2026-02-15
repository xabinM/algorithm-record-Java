package baekjoon.graphSearch.dfs;

import java.util.Scanner;

public class BucketBrigade {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] graph = new char[10][10];

        Node start = null;
        Node end = null;

        for (int i = 0; i < 10; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < 10; j++) {
                char cur = line.charAt(j);
                graph[i][j] = cur;

                if (cur == 'B') {
                    start = new Node(i, j);
                } else if (cur == 'L') {
                    end = new Node(i, j);
                }
            }
        }

        boolean[][] visited = new boolean[10][10];

        dfs(graph, start, end, 0, visited);

        System.out.println(min);
    }

    public static void dfs(char[][] graph, Node start, Node end, int depth, boolean[][] visited) {

        if (depth >= min) {
            return;
        }

        int x = start.x;
        int y = start.y;

        if (x == end.x && y == end.y) {
            min = Math.min(min, depth - 1);
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= 10 || ny < 0 || ny >= 10 || visited[nx][ny] || graph[nx][ny] == 'R') {
                continue;
            }

            dfs(graph, new Node(nx, ny), end, depth + 1, visited);
        }

        visited[x][y] = false;
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