package baekjoon.backTrack;

import java.util.Scanner;

public class Permutation9742 {
    private static String[] material;
    private static int goalIdx;
    private static int cnt;
    private static String result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){
            String[] input = sc.nextLine().split(" ");

            String str = input[0];
            goalIdx = Integer.parseInt(input[1]);

            material = str.split("");

            cnt = 0;
            result = "";

            backTrack(new StringBuilder(), new boolean[material.length]);

            if (result.isEmpty()) {
                System.out.println(str + " " + goalIdx + " = No permutation");
                continue;
            }
            System.out.println(str + " " + goalIdx + " = " + result);
        }
    }

    private static void backTrack(StringBuilder sb, boolean[] visited) {
        if (sb.length() == material.length) {
            cnt++;
            if (cnt == goalIdx) {
                result = String.valueOf(sb);
            }
            return;
        }

        if (cnt == goalIdx) {
            return;
        }

        for (int i = 0; i < material.length; i++) {
            if (i > 0 && material[i].equals(material[i - 1]) && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                sb.append(material[i]);
                backTrack(sb, visited);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
}
