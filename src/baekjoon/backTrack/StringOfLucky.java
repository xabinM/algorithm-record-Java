package baekjoon.backTrack;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StringOfLucky {
    private static String[] input;
    private static int N;
    private static boolean[] visited;
    private static Set<String> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        input = sc.nextLine().split("");
        N = input.length;
        visited = new boolean[N];
        result = new HashSet<>();

        backTrack(0, new StringBuilder());

        System.out.println(result.size());
    }

    private static void backTrack(int depth, StringBuilder sb) {
        if (depth == N) {
            if (checkNextChar(sb)) {
                result.add(sb.toString());
            }
            return;
        }

        if (!checkNextChar(sb)) {
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]){
                sb.append(input[i]);
                visited[i] = true;
                backTrack(depth + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }

    private static boolean checkNextChar(StringBuilder sb) {
        boolean flag = true;
        String[] temp = sb.toString().split("");
        for (int i = 0; i < sb.length() - 1; i++) {
            if (temp[i].equals(temp[i + 1])) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
