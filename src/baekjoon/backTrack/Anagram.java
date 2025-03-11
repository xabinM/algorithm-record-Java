package baekjoon.backTrack;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Anagram {
    private static int N;
    private static Set<String> result;
    private static String[] splited;
    private static int len;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            splited = sc.next().split("");
            len = splited.length;
            visited = new boolean[len];
            result = new TreeSet<>();

            backTrack(new StringBuilder(), 0);

            for (String value : result) {
                System.out.println(value);
            }
        }
    }

    private static void backTrack(StringBuilder sb, int depth) {
        if (depth == len) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!visited[i]){
                sb.append(splited[i]);
                visited[i] = true;
                backTrack(sb, depth + 1);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
