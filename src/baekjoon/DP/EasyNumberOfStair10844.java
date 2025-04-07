package baekjoon.DP;

import java.util.Scanner;

public class EasyNumberOfStair10844 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[][] dp = new long[N + 1][10];

        int MOD = 1_000_000_000;

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j > 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                if (j < 9) {
                    dp[i][j] += dp[i - 1][j + 1];
                }
                dp[i][j] %= MOD;
            }
        }

        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum = (sum + dp[N][i]) % MOD;
        }

        System.out.println(sum);
    }
}
