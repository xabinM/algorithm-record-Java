package baekjoon.backTrack;

import java.util.Scanner;

public class InequalitySign2529 {
    private static int N;
    private static String[] inequality;
    private static boolean[] visited;
    private static long minInt = Long.MAX_VALUE;
    private static long maxInt = Long.MIN_VALUE;
    private static String minStr;
    private static String maxStr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();

        inequality = sc.nextLine().split(" ");
        visited = new boolean[10];

        backTrack(new StringBuilder(), 0, 0);

        System.out.println(maxStr);
        System.out.println(minStr);
    }

    private static void backTrack(StringBuilder sb, int depth, int preVal) {

        if (depth == N + 1) {
            long temp = Long.parseLong(sb.toString());
            if (temp < minInt) {
                minInt = temp;
                minStr = sb.toString();
            }
            if (temp > maxInt) {
                maxInt = temp;
                maxStr = sb.toString();
            }
            return;
        }


        for (int i = 0; i < 10; i++) {
            if (visited[i]) {
                continue;
            }

            if (depth != 0) {
                if (inequality[depth - 1].equals("<") && preVal > i) {
                    continue;
                } else if (inequality[depth - 1].equals(">") && preVal < i) {
                    continue;
                }
            }

            sb.append(i);
            visited[i] = true;
            backTrack(sb, depth + 1, i);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
