package baekjoon.avatar;

import java.util.Arrays;
import java.util.Scanner;

public class WizardSharkAndRainDance {
    private static int N, M;
    private static int[][] baskets;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        baskets = new int[N][N];
        for (int i = 0; i < N; i++) {
            baskets[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < M; i++) {
            int d = sc.nextInt();   // 방향 1 ~ 8 (9시부터 시계방향)
            int s = sc.nextInt();   // 이동 칸 수
        }
    }
}
