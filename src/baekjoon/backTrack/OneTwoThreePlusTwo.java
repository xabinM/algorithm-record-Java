package baekjoon.backTrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OneTwoThreePlusTwo {

    private static int n, k;
    private static List<Integer> result;
    private static int cnt = 0;
    private static boolean flag;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        result = new ArrayList<>();

        backtrack(0);

        if (!flag) {
            System.out.println(-1);
        }
    }

    private static void backtrack(int sum) {
        if (flag) {
            return;
        }

        if (sum == n) {
            cnt++;
            if (cnt == k) {
                printResult();
                flag = true;
                return;
            }
        }

        if (sum > n) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            result.add(i);
            backtrack(sum + i);
            result.removeLast();    // java 21 이상 문법이라 제출시는 컴파일 에러
        }
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
            if (i < result.size() - 1) {
                sb.append("+");
            }
        }
        System.out.println(sb);
    }
}
