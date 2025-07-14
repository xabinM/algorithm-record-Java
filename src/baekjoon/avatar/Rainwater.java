package baekjoon.avatar;

import java.util.Arrays;
import java.util.Scanner;

public class Rainwater {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();   // 세로길이
        int W = sc.nextInt();   // 가로길이
        sc.nextLine();

        int[] blocks = Arrays.stream(sc.nextLine().split(" ")
                ).mapToInt(Integer::parseInt)
                .toArray();

        int totalWater = 0;

        for (int i = 1; i < W - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;

            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, blocks[j]);
            }

            for (int j = i + 1; j < W; j++) {
                rightMax = Math.max(rightMax, blocks[j]);
            }

            int water = Math.min(leftMax, rightMax) - blocks[i];
            if (water > 0) totalWater += water;
        }

        System.out.println(totalWater);
    }
}
