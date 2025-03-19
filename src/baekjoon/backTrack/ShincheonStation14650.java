package baekjoon.backTrack;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ShincheonStation14650 {
    private static int N;
    private static Set<Integer> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        result = new HashSet<>();

        backTrack(new StringBuilder(), 0);

        System.out.println(result.size());
    }

    private static void backTrack(StringBuilder sb, int depth) {
        if (depth == N) {
            int temp = Integer.parseInt(sb.toString());
            if (temp % 3 == 0) {
                result.add(temp);
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (depth == 0 && i == 0) {
                continue;
            }
            sb.append(i);
            backTrack(sb, depth + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
