package baekjoon.backTrack;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram6443 {
    private static int N;
    private static String[] splited;
    private static int len;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            splited = sc.next().split("");
            Arrays.sort(splited);
            len = splited.length;
            visited = new boolean[len];

            backTrack(new StringBuilder(), 0);
        }
    }

    private static void backTrack(StringBuilder sb, int depth) {
        if (depth == len) {
            System.out.println(sb.toString());
            return;
        }

        String lastUsed =  null;
        for (int i = 0; i < len; i++) {
            if (visited[i]) continue;

            if (splited[i].equals(lastUsed)) continue;

            sb.append(splited[i]);
            visited[i] = true;
            lastUsed = splited[i];
            backTrack(sb, depth + 1);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
