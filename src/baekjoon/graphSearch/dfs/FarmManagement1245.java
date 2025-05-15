package baekjoon.graphSearch.dfs;

import java.util.Scanner;

public class FarmManagement1245 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static boolean isPeak;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    isPeak = true;
                    dfs(i, j, map[i][j]);
                    if (isPeak) count++;
                }
            }
        }

        System.out.println(count);
    }

    static void dfs(int x, int y, int height) {
        visited[x][y] = true;

        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                continue;

            if (map[nx][ny] > height)
                isPeak = false;

            if (!visited[nx][ny] && map[nx][ny] == height)
                dfs(nx, ny, height);
        }
    }

}
