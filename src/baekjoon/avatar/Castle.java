package baekjoon.avatar;

import java.util.*;

public class Castle {
    private static int N, M, D;
    private static int maxKill = Integer.MIN_VALUE;
    private static int[][] field;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        D = sc.nextInt();
        sc.nextLine();

        field = new int[N][M];
        for (int i = 0; i < N; i++) {
            field[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        combination(0, 0, new int[3]);

        System.out.println(maxKill);
    }

    private static void combination(int depth, int start, int[] archers) {
        if (depth == 3) {
            maxKill = Math.max(maxKill, simulator(archers));
            return;
        }

        for (int i = start; i < M; i++) {
            archers[depth] = i;
            combination(depth + 1, i + 1, archers);
        }
    }

    private static int simulator(int[] archers) {
        int curKill = 0;

        int[][] tempField = new int[N][M];
        for (int i = 0; i < N; i++) {
            tempField[i] = field[i].clone();
        }

        for (int turn = 0; turn < N; turn++) {
            Set<Point> targets = new HashSet<>();

            for (int archerCol : archers) {
                Point target = bfs(tempField, archerCol);
                if (target != null) {
                    targets.add(target);
                }
            }

            for (Point p : targets) {
                tempField[p.x][p.y] = 0;
                curKill++;
            }

            for (int i = N - 1; i > 0; i--) {
                tempField[i] = tempField[i - 1];
            }
            tempField[0] = new int[M];
        }

        return curKill;
    }

    private static Point bfs(int[][] field, int archerCol) {
        int[] dx = {0, -1, 0};
        int[] dy = {-1, 0, 1};

        boolean[][] visited = new boolean[N][M];
        Deque<Point> queue = new ArrayDeque<>();

        queue.offer(new Point(N - 1, archerCol, 1));
        visited[N - 1][archerCol] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int d = cur.dist;

            if (d > D) {
                break;
            }

            if (field[x][y] == 1) {
                return new Point(x, y);
            }

            for (int k = 0; k < 3; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, d + 1));
                }
            }
        }

        return null;
    }

    private static class Point {
        int x, y, dist;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
