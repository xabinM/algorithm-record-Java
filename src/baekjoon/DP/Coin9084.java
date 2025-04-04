package baekjoon.DP;

import java.util.Arrays;
import java.util.Scanner;

public class Coin9084 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            sc.nextLine();

            int[] coins = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int price = sc.nextInt();

            int[] dp = new int[price + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int i = 0; i < price + 1; i++) {
                    if (i >= coin) {
                        dp[i] += dp[i - coin];
                    }
                }
            }

            System.out.println(dp[price]);
        }
    }
}
