package SSAFY.dp.배낭문제;

import java.util.Arrays;
import java.util.Scanner;

public class HamburgerDiet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();   // 재료의 수
            int L = sc.nextInt();   // 제한 칼로리
            sc.nextLine();

            int[][] material = new int[N + 1][2];
            for (int i = 1; i <= N; i++) {
                material[i] = Arrays.stream(sc.nextLine().split(" ")).
                        mapToInt(Integer::parseInt).toArray();
            }

            int[][] dp = new int[L + 1][N + 1];

            for (int i = 1; i <= L; i++) {
                for (int j = 1; j <= N; j ++) {
                    if (i < material[j][1]) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - material[j][1]][j - 1] + material[j][0], dp[i][j - 1]);
                    }
                }
            }

            System.out.println("#" + t + " " + dp[L][N]);
        }
    }
}
