package SSAFY.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfSubsequence {
    private static int cnt;
    private static int N;
    private static int K;
    private static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            K = sc.nextInt();
            sc.nextLine();

            cnt = 0;

            numbers = Arrays.stream(sc.nextLine().split(" ")).
                    mapToInt(Integer::parseInt).toArray();

            dfs(0, 0);

            System.out.println("#" + t + " " + cnt);

        }
        sc.close();

    }

    private static void dfs(int idx, int sum) {
        if (sum == K) {
            cnt += 1;
            return;
        }
        if (sum >= K || idx >= N) {
            return;
        }

        for (int i = idx; i < N; i++) {
            sum += numbers[i];
            dfs(i + 1, sum);
            sum -= numbers[i];
        }
    }
}
