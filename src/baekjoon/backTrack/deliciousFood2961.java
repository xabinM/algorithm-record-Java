package baekjoon.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class deliciousFood2961 {
    private static int N;
    private static List<int[]> materials;
    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();

        materials = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            materials.add(Arrays.stream(sc.nextLine().split(" ")).
                    mapToInt(Integer::parseInt).toArray());
        }

        result = Integer.MAX_VALUE;

        backTrack(1, 0, 0);

        System.out.println(result);
    }

    private static void backTrack(int sourMultiply, int bitterSum, int depth) {
        if (depth == N) {
            if (sourMultiply != 1 || bitterSum != 0) {
                result = Math.min(result, Math.abs(sourMultiply - bitterSum));
            }
            return;
        }

        backTrack(sourMultiply * materials.get(depth)[0],
                bitterSum + materials.get(depth)[1], depth + 1);
        backTrack(sourMultiply, bitterSum, depth + 1);
    }
}
