package SSAFY.dp.배낭문제;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();   // 물건의 수
            int K = sc.nextInt();   // 최대 무게
            sc.nextLine();

            int[][] stuff = new int[N + 1][2];
            for (int i = 1; i <= N; i++) {
                stuff[i] = Arrays.stream(sc.nextLine().split(" ")).
                        mapToInt(Integer::parseInt).toArray();
            }

            int[][] dp = new int[K + 1][N + 1];

            for (int i = 1; i <= K; i++) {
                for (int j = 1; j <= N; j ++) {
                    if (i < stuff[j][0]) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - stuff[j][0]][j - 1] + stuff[j][1], dp[i][j - 1]);
                    }
                }
            }

            System.out.println("#" + t + " " + dp[K][N]);
        }
    }
}
