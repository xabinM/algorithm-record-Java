package baekjoon.backTrack;

import java.util.*;

public class BiggerAndSmallest {
    private static int origin;
    private static int[] input;
    private static int leng;
    private static boolean[] visited;
    private static int minValue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        origin = sc.nextInt();

        input = Arrays.stream(String.valueOf(origin).split("")).
                mapToInt(Integer::parseInt).
                toArray();
        leng = input.length;
        visited = new boolean[leng];
        minValue = Integer.MAX_VALUE;

        backTrack(new StringBuilder(), 0, false);

        if (minValue == Integer.MAX_VALUE) {
            System.out.println(0);
            return;
        }
        System.out.println(minValue);

    }

    private static void backTrack(StringBuilder sb, int depth, boolean alreadyBigger) {
        if (depth == leng) {
            int target = Integer.parseInt(sb.toString());
            if (target > origin) {
                minValue = Math.min(minValue, Integer.parseInt(sb.toString()));
            }
            return;
        }

        for (int i = 0; i < leng; i++) {
            if (visited[i]) continue;

            if (input[i] > input[depth]) {
                alreadyBigger = true;
            }

            if (!alreadyBigger && input[i] < input[depth]) {
                continue;
            }

            sb.append(input[i]);
            visited[i] = true;
            backTrack(sb, depth + 1, alreadyBigger);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
}