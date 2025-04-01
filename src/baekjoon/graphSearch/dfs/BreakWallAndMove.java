package baekjoon.graphSearch.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class BreakWallAndMove {
    private static int N;
    private static int M;
    private static int[][] graph;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(sc.nextLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        dfs(0, 0, 1, true, new boolean[N][M]);

        if (result != Integer.MAX_VALUE){
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    private static void dfs(int x, int y, int depth, boolean drill, boolean[][] visited) {
        if (x == N - 1 && y == M - 1) {
            result = Math.min(result ,depth);
            return;
        }

        visited[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                if (depth >= result) {
                    continue;
                }

                if (graph[nx][ny] == 1 && !drill) {
                    continue;
                } else if (graph[nx][ny] == 1 && drill) {
                    dfs(nx, ny, depth + 1, false, visited);
                    continue;
                }
                dfs(nx, ny, depth + 1, drill, visited);
            }
        }
        visited[x][y] = false;
    }
}
