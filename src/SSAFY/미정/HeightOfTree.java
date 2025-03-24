package SSAFY.미정;

import java.util.Arrays;
import java.util.Scanner;

public class HeightOfTree {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            sc.nextLine();

            int[] trees = Arrays.stream(sc.nextLine().split(" ")).
                    mapToInt(Integer::parseInt).toArray();

            int max = Arrays.stream(trees).max().orElse(0);

            int odd = 0;
            int even = 0;
            // 각 나무가 자라야 할 높이 차이 계산
            for (int i = 0; i < N; i++) {
                int heightToGrow = max - trees[i];

                even += heightToGrow / 2;

                if (heightToGrow % 2 != 0) {
                    odd += heightToGrow % 2;
                }
            }

            if (even > odd) {
                while (Math.abs(even - odd) > 1) {
                    odd += 2;
                    even -= 1;
                }
            }

            int result;
            if (odd > even) {
                result = odd * 2 - 1;
            } else {
                result = even * 2;
            }

            System.out.println("#" + t + " " + result);
        }
    }
}
