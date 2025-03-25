package SSAFY.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class SwimmingPool {
    private static int[] price, months;
    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int t = 1; t <= T; t++) {
            price = Arrays.stream(sc.nextLine().
                    split(" ")).mapToInt(Integer::parseInt).toArray();

            months = new int[13];
            for (int i = 1; i < 13; i++) {
                months[i] = sc.nextInt() * price[0];
            }
            sc.nextLine();

            result = price[3];  // 결과의 초기 값을 1년 비용으로 설정

            dfs(1, 0);

            System.out.println("#" + t + " " + result);
        }
    }

    private static void dfs (int depth, int sum) {
        if (depth >= 13) {
            result = Math.min(result, sum);
            return;
        }

        dfs(depth + 1, sum + Math.min(months[depth], price[1]));

        dfs(depth + 3, sum + price[2]);
    }
}
