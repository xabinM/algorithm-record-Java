package baekjoon.backTrack;

import java.util.Arrays;
import java.util.Scanner;

public class ExamOfYoungJae {
    private static int[] numbers;
    private static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        numbers = Arrays.stream(sc.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();

        backTrack(0, 0, 0, 0);

        System.out.println(result);
    }

    private static void backTrack(int depth, int preAns, int preAns2, int score) {
        if (score >= 5) {
            result += 1;
            return;
        }

        if (depth == 10) {
            return;
        }


        for (int i = depth; i < 10; i++) {
            if (depth == 0 || depth == 1) {
                backTrack(depth + 1, numbers[i], preAns, score + 1);
                backTrack(depth + 1, preAns, preAns2, score);
            } else {
                if (numbers[i] != preAns || numbers[i] != preAns2) {
                    backTrack(depth + 1, numbers[i], preAns, score + 1);
                    backTrack(depth + 1, preAns, preAns2, score);
                } else {
                    backTrack(depth + 1, preAns, preAns2, score);
                }
            }
        }
    }
}
