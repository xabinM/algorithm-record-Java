package baekjoon.graphSearch.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ColoredPaperAndCrafts {
    private static int N, M;
    private static String[][] paper;
    private static int cnt;
    private static int row;
    private static int col;
    private static boolean[][] visited;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        paper = new String[N][M];
        for (int i = 0; i < N; i++) {
            paper[i] = sc.nextLine().split("");
        }

        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    bfs(new Node(i, j), paper[i][j]);

                    if ((row + 1) * (col + 1) != cnt) {
                        System.out.println("BaboBabo");
                        return;
                    }
                    cnt = 0;
                    row = 0;
                    col = 0;
                }
            }
        }
        System.out.println("dd");
    }

    private static void bfs(Node start, String color) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;

            cnt++;
            row = Math.max(row, y - start.y);
            col = Math.max(col, x - start.x);

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && paper[nx][ny].equals(color)) {
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
