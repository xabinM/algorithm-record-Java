package baekjoon.DP;

import java.util.Scanner;

public class SumDecomposition2225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 목표 합
        int K = sc.nextInt(); // 사용하는 숫자 개수

        int MOD = 1_000_000_000;
        int[][] dp = new int[K + 1][N + 1];

        // 초기값: 0개의 수로 0 만드는 경우는 1개
        dp[0][0] = 1;

        for (int k = 1; k <= K; k++) {
            for (int n = 0; n <= N; n++) {
                for (int i = 0; i <= n; i++) {
                    dp[k][n] = (dp[k][n] + dp[k - 1][n - i]) % MOD;
                }
            }
        }

        System.out.println(dp[K][N]);
    }
}
