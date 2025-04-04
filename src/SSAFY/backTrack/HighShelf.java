package SSAFY.backTrack;

import java.util.Arrays;
import java.util.Scanner;

public class HighShelf {
    private static int N;
    private static int B;
    private static int[] height;
    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();   // 점원 수
            B = sc.nextInt();   // 선반 높이
            sc.nextLine();

            height = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            result = Integer.MAX_VALUE;

            dfs(0, 0);

            System.out.println("#" + t + " " + result);
        }
    }

    private static void dfs(int depth, int sum) {
        if (sum >= B) {
            result = Math.min(result, sum - B);
            return;
        }

        if (depth == N) {
            return;
        }

        dfs(depth + 1, sum + height[depth]);
        dfs(depth + 1, sum);
    }
}
