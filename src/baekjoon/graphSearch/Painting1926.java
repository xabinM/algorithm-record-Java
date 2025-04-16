package baekjoon.graphSearch;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Painting1926 {
    private static int n;
    private static int m;
    private static int[][] graph;
    private static boolean[][] visited;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int cnt = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        visited = new boolean[n][m];
        int maxExtend = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    int curExtend = bfs(new Node(i, j));
                    maxExtend = Math.max(maxExtend, curExtend);
                }
            }
        }
        System.out.println(cnt);
        System.out.println(maxExtend);
    }

    private static int bfs(Node start) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.x][start.y] = true;

        int curExtend = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            curExtend++;
            int x = cur.x;
            int y = cur.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (graph[nx][ny] == 1 && !visited[nx][ny]){
                        queue.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        cnt++;
        return curExtend;
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
