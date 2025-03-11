package baekjoon.backTrack;

import java.util.Arrays;
import java.util.Scanner;

public class StringOfLucky1342 {
    private static String[] input;
    private static int N;
    private static boolean[] visited;
    private static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        input = sc.nextLine().split("");
        Arrays.sort(input);
        N = input.length;
        visited = new boolean[N];
        cnt = 0;

        backTrack(0, new StringBuilder());

        System.out.println(cnt);

    }

    private static void backTrack(int depth, StringBuilder sb) {
        if (depth == N) {
            if (checkNextChar(sb)){
                cnt++;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && input[i].equals(input[i - 1]) && !visited[i - 1]){
               continue;
            }
            sb.append(input[i]);
            visited[i] = true;
            backTrack(depth + 1, sb);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
            }
    }

    private static boolean checkNextChar(StringBuilder sb) {
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                return false; // 연속된 문자 발견
            }
        }
        return true;
    }
}
