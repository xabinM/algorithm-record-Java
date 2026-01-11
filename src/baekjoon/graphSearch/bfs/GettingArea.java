package baekjoon.graphSearch.bfs;

import java.util.*;

public class GettingArea {

    private static int N, M, K;
    private static int[][] graph;
    private static boolean[][] visited;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

        graph = new int[M][N];
        for (int i = 0; i < K; i++) {
            int[] temp = new int[4];
            for (int j = 0; j < 4; j++) {
                temp[j] = sc.nextInt();
            }

            for (int j = temp[0]; j < temp[2]; j++) {
                for (int k = temp[1]; k < temp[3]; k++) {
                    graph[k][j]++;
                }
            }
        }

        visited = new boolean[M][N];
        int cnt = 0;
        List<Integer> wides = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && graph[i][j] == 0) {
                    cnt++;
                    wides.add(bfs(new Node(i, j)));
                }
            }
        }

        Collections.sort(wides);

        System.out.println(cnt);
        for (int wide : wides) {
            System.out.print(wide + " ");
        }
    }

    private static int bfs(Node node) {
        Deque<Node> queue = new ArrayDeque<>();
        int wide = 1;

        visited[node.x][node.y] = true;

        queue.offer(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && graph[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        queue.offer(new Node(nx, ny));
                        wide++;
                    }
                }
            }
        }

        return wide;
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
