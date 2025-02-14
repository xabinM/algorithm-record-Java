package SSAFY.이차원배열;

import java.util.Scanner;

public class CropsHarvest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            sc.nextLine();

            int[][] graph = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] temp = sc.nextLine().split("");
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(temp[j]);
                }
            }

            int centerIdx = N / 2;
            int result = 0;

            for (int i = 0; i < N; i++) {
                int start = Math.abs(centerIdx - i);
                int end = N - start - 1;

                for (int j = start; j <= end; j++) {
                    result += graph[i][j];
                }
            }

            System.out.println("#" + t + " " + result);
        }
    }
}
