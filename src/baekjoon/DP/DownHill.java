package baekjoon.DP;

import java.util.Arrays;
import java.util.Scanner;

public class DownHill {
    private static int M;
    private static int N;
    private static int[][] graph;
    private static boolean[][] visited;
    private static int cnt;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        sc.nextLine();

        graph = new int[M][N];
        for (int i = 0; i < M; i++) {
            graph[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        visited = new boolean[M][N];

        dfs(0, 0);

        System.out.println(cnt);
    }

    //dfs
    private static void dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            cnt++;
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (!visited[nx][ny] && graph[nx][ny] < graph[x][y]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
