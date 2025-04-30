package baekjoon.avatar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class RobotCleaner14503 {
    private static int N, M;
    private static int[][] graph;
    private static boolean[][] visited;
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        int x = sc.nextInt();
        int y = sc.nextInt();
        int d = sc.nextInt();
        sc.nextLine();

        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        visited = new boolean[N][M];

        work(x, y, d);

        System.out.println(count);
    }

    private static void work(int x, int y, int direction) {
        while (true) {
            if (!visited[x][y]) {
                visited[x][y] = true;
                count++;
            }

            boolean moved = false;

            for (int k = 0; k < 4; k++) {
                direction = (direction + 3) % 4;
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (graph[nx][ny] == 0 && !visited[nx][ny]) {
                        x = nx;
                        y = ny;
                        moved = true;
                        break;
                    }
                }
            }

            if (!moved) {
                int back = (direction + 2) % 4;
                int bx = x + dx[back];
                int by = y + dy[back];

                if (bx >= 0 && bx < N && by >= 0 && by < M && graph[bx][by] == 0) {
                    x = bx;
                    y = by;
                } else {
                    break;
                }
            }
        }
    }
}
