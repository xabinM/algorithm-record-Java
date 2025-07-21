package baekjoon.avatar;

import java.util.*;

public class WizardSharkAndRainDance {
    private static int N, M;
    private static int[][] baskets;
    private static final int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    private static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        baskets = new int[N][N];
        for (int i = 0; i < N; i++) {
            baskets[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        Deque<Node> curNodes = new ArrayDeque<>();
        curNodes.offer(new Node(N - 1, 0));
        curNodes.offer(new Node(N - 2, 0));
        curNodes.offer(new Node(N - 1, 1));
        curNodes.offer(new Node(N - 2, 1));

        for (int i = 0; i < M; i++) {
            int d = sc.nextInt() - 1;   // 방향 1 ~ 8 (9시부터 시계방향)
            int s = sc.nextInt();   // 이동 칸 수

            boolean[][] visited = new boolean[N][N];
            List<Node> afterMove = new ArrayList<>();

            while (!curNodes.isEmpty()) {
                Node node = curNodes.poll();
                int x = node.x;
                int y = node.y;

                int nx = (x + (dx[d] * s) % N + N) % N;
                int ny = (y + (dy[d] * s) % N + N) % N;

                visited[nx][ny] = true;
                baskets[nx][ny]++;
                afterMove.add(new Node(nx, ny));
            }

            for (Node node : afterMove) {
                int x = node.x;
                int y = node.y;

                for (int k = 1; k < 8; k = k + 2) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (baskets[nx][ny] > 0) baskets[x][y]++;
                }
            }

            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    if (!visited[a][b] && baskets[a][b] >= 2 ) {
                        curNodes.offer(new Node(a, b));
                        baskets[a][b] -= 2;
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += baskets[i][j];
            }
        }
        System.out.println(sum);
    }

    private static void search(int x, int y) {

        for (int i = 1; i < 8; i = i + 2) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }
            if (baskets[nx][ny] > 0) {
                baskets[x][y]++;
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
