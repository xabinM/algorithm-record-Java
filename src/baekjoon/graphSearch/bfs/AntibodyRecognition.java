package baekjoon.graphSearch.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class AntibodyRecognition {
    private static int N, M;
    private static int[][] origin;
    private static int[][] trans;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        origin = new int[N][M];
        trans = new int[N][M];
        for (int i = 0; i < N; i++) {
            origin[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        for (int i = 0; i < N; i++) {
            trans[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        if (Arrays.deepEquals(origin, trans)) {
            System.out.println("YES");
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (origin[i][j] != trans[i][j]) {
                    if (bfs(copy(origin), new Node(i, j), trans[i][j], new boolean[N][M])) {
                        System.out.println("YES");
                        return;
                    }
                }
            }
        }
        System.out.println("NO");
    }

    private static boolean bfs(int[][] array, Node start, int target, boolean[][] visited) {
        int originValue = array[start.x][start.y];
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.x][start.y] = true;

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            array[x][y] = target;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && array[nx][ny] == originValue) {
                        queue.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return Arrays.deepEquals(array, trans);
    }

    private static int[][] copy(int[][] array) {
        int[][] copied = new int[array.length][];
        for (int i = 0; i < array.length; i++) {
            copied[i] = Arrays.copyOf(array[i], array[i].length);
        }

        return copied;
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
