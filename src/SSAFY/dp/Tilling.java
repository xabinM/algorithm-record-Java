package SSAFY.dp;

import java.math.BigInteger;
import java.util.Scanner;

public class Tilling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();

            BigInteger[] dp = new BigInteger[N + 2];

            dp[0] = BigInteger.valueOf(0);
            dp[1] = BigInteger.valueOf(1);
            dp[2] = BigInteger.valueOf(3);

            for (int i = 3; i < N + 1; i++) {
                dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
            }

            System.out.println("#" + t + " " + dp[N]);
        }
    }
}
