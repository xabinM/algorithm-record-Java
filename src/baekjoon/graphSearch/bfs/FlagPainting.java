package baekjoon.graphSearch.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class FlagPainting {
    private static int N, M;
    private static String[][] A, B;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        A = new String[N][M];
        B = new String[N][M];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLine().split("");
        }

        for (int i = 0; i < N; i++) {
            B[i] = sc.nextLine().split("");
        }


    }

    private static String[][] bfs(Node start, String target, String[][] temp, boolean[][] visited) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.x][start.y] = true;
        String origin = temp[start.x][start.y];

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            temp[x][y] = target;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (temp[nx][ny].equals(origin) && !visited[nx][ny]) {
                        queue.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return temp;
    }

    private static String[][] deepCopy(String[][] original) {
        String[][] copy = new String[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
