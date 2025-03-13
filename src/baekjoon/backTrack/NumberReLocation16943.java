package baekjoon.backTrack;

import java.util.Arrays;
import java.util.Scanner;

public class NumberReLocation16943 {
    private static int B;
    private static int[] arrA;
    private static int[] arrB;
    private static int lenA;
    private static boolean[] visited;
    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        B = sc.nextInt();
        arrA = Arrays.stream(String.valueOf(A).split("")).mapToInt(Integer::parseInt).toArray();
        arrB = Arrays.stream(String.valueOf(B).split("")).mapToInt(Integer::parseInt).toArray();
        lenA = arrA.length;
        int lenB = arrB.length;
        visited = new boolean[lenA];
        result = -1;

        int[] temp = new int[lenA];


        if (lenA > lenB) {
            System.out.println(-1);
            return;
        } else {
            backTrack(temp, 0, false);
        }

        System.out.println(result);
    }

    private static void backTrack(int[] temp, int depth, boolean alreadySmaller) {
        if (depth == lenA) {
            // 완성된 배열 하나의 숫자로 합치기
            int cur = joinArr(temp);

            // B보다 작으면서 최대 값 갱신
            if (cur < B) {
                result = Math.max(result, cur);
            }
            return;
        }

        for (int i = 0; i < lenA; i++) {
            if (depth == 0 && arrA[i] == 0) {
                continue;
            }

            if (!visited[i]) {
                if (!alreadySmaller && arrB[depth] < arrA[i]) {
                    continue;
                }
                if (arrA[i] < arrB[depth]) {
                    alreadySmaller = true;
                }

                temp[depth] = arrA[i];
                visited[i] = true;
                backTrack(temp, depth + 1, alreadySmaller);
                visited[i] = false;
            }
        }
    }

    private static int joinArr (int[] temp){
        int cur = 0;
        int location = temp.length;
        for (int j : temp) {
            if (location == 0) {
                cur += temp[temp.length - 1];
            }
            cur += (int) (j * Math.pow(10, location-- - 1));
        }
        return cur;
    }
}
