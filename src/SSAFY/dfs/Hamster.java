package SSAFY.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class Hamster {
    private static int N;   // 햄스터 우리 수
    private static int X;   // 각 우리에 들어갈 수 있는 햄스터 수
    private static int M;   // 기록 개수
    private static int[][] record;
    private static int maxCheck;
    private static StringBuilder result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            X = sc.nextInt();
            M = sc.nextInt();
            sc.nextLine();

            record = new int[M][3];
            for (int i = 0; i < M; i++) {
                record[i] = Arrays.stream(sc.nextLine().split(" ")).
                        mapToInt(Integer::parseInt).toArray();
            }

            maxCheck = Integer.MIN_VALUE;
            result = null;

            backTrack(new StringBuilder(), 0);

            System.out.print("#" + t);
            if (result == null) {
                System.out.println(" " + -1);
                continue;
            }

            String[] strResult = result.toString().split("");

            for (String ch : strResult) {
                System.out.print(" " + ch);
            }
            System.out.println();
        }
    }

    private static void backTrack(StringBuilder sb, int depth) {
        if (depth == N) {
            if (checkCondition(sb)) {
                if (sumOfSB(sb) > maxCheck) {
                    maxCheck = sumOfSB(sb);
                    result = new StringBuilder(sb);     // new StringBuilder 를 만들지 않고 그냥 sb를 할당할시 sb가 변경되면 result에 변경된 값이 담긴다.
                } else if (sumOfSB(sb) == maxCheck) {
                    result = orderByDictionary(result, sb);
                }
            }
            return;
        }

        for (int i = 0; i <= X; i++) {
            sb.append(i);
            backTrack(sb, depth + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static StringBuilder orderByDictionary(StringBuilder sb1, StringBuilder sb2) {
        String a = sb1.toString();
        String b = sb2.toString();

        String[] arr = {a, b};

        Arrays.sort(arr);

        return new StringBuilder(arr[0]);
    }

    private static int sumOfSB(StringBuilder sb) {
        return Arrays.stream(sb.toString().split("")).
                mapToInt(Integer::parseInt).sum();
    }

    private static boolean checkCondition(StringBuilder sb)  {
        for (int[] condition : record) {
            int l = condition[0];
            int r = condition[1];
            int s = condition[2];
            int temp = 0;

            for (int i = l - 1; i < r; i++) {
                temp += Integer.parseInt(String.valueOf(sb.charAt(i)));
            }

            if (temp != s) {
                return false;
            }
        }
        return true;
    }
}
