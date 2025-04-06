package baekjoon.DP;

import java.util.Scanner;

public class SumDecomposition {
    private static int N;
    private static int K;
    private static int cnt;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        dfs(0, 0);

        System.out.println(cnt);
    }

    private static void dfs(int depth, int sum) {
        if (depth == K) {
            if (sum == N) {
                cnt++;
            }
            return;
        }

        for (int i = 0; i <= N; i++) {
            if (sum + i <= N){
                sum += i;
                dfs(depth + 1, sum);
                sum -= i;
            }
        }
    }
}
