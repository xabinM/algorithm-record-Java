package baekjoon.backTrack;

import java.util.Scanner;

public class FlowerWay {

    private static int N;
    private static int[][] graph;
    private static boolean[][] visited;
    private static int[] dx = {0, -1, 1, 0, 0};
    private static int[] dy = {0, 0, 0, -1, 1};
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[N][N];

        backTrack(0, 0);
        System.out.println(min);
    }

    private static void backTrack(int depth, int totalCost) {

        if (depth == 3) {
            min = Math.min(min, totalCost);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (checkFlower(i, j)) {
                    int curCost = setFlower(i, j, true);
                    backTrack(depth + 1, totalCost + curCost);
                    setFlower(i, j, false);
                }
            }
        }
    }

    private static boolean checkFlower(int x, int y) {

        for (int k = 0; k < 5; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (visited[nx][ny]) return false;
        }
        return true;
    }

    private static int setFlower(int x, int y, boolean flag) {

        int sum = 0;

        for (int k = 0; k < 5; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            visited[nx][ny] = flag;
            sum += graph[nx][ny];
        }

        return sum;
    }
}
