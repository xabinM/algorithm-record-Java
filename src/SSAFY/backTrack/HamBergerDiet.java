package SSAFY.backTrack;

import java.util.Arrays;
import java.util.Scanner;

public class HamBergerDiet {
    private static int N;
    private static int L;
    private static int[][] material;
    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();   // 재료의 수
            L = sc.nextInt();   // 제한 칼로리
            sc.nextLine();

            material = new int[N][2];

            for (int i = 0; i < N; i++) {
                material[i] = Arrays.stream(sc.nextLine().split(" ")).
                        mapToInt(Integer::parseInt).
                        toArray();
            }

            result = Integer.MIN_VALUE;

            backTrack(0, 0, 0);

            System.out.println("#" + t + " " + result);
        }
    }
    private static void backTrack(int idx, int sumScore, int sumCalories) {
        if (sumCalories > L) {
            return;
        } else if (sumCalories == L){
            result = Math.max(result, sumScore);
            return;
        } else {
            result = Math.max(result, sumScore);
        }

        for (int i = idx; i < N; i++) {
            sumScore += material[i][0];
            sumCalories += material[i][1];
            backTrack(i + 1, sumScore, sumCalories);
            sumScore -= material[i][0];
            sumCalories -= material[i][1];
        }
    }
}
