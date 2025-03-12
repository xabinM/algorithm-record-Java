package baekjoon.backTrack;

import java.util.Arrays;
import java.util.Scanner;

public class NumberReLocation16943 {
    private static int A;
    private static int B;
    private static int[] arrA;
    private static int[] arrB;
    private static int lenA;
    private static int lenB;
    private static boolean[] visited;
    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();
        arrA = Arrays.stream(String.valueOf(A).split("")).mapToInt(Integer::parseInt).toArray();
        arrB = Arrays.stream(String.valueOf(B).split("")).mapToInt(Integer::parseInt).toArray();
        System.out.println("arrA : " + Arrays.toString(arrA));
        System.out.println("arrB : " + Arrays.toString(arrB));
        lenA = arrA.length;
        lenB = arrB.length;
        visited = new boolean[lenA];
        result = Integer.MIN_VALUE;

        int[] temp = new int[lenA];


        if (lenA > lenB) {
            System.out.println(-1);
            return;
        } else {
            backTrack(temp, 0, false);
        }

        System.out.println(result);
    }
    // A 랑 B의 자리수를 비교해서 분기를 3개로 쪼개야될듯?
    // 1. A.len > B.len : B보다 작아질 수 있는 수가 없기 때문에 -1 출력
    // 2. A.len = B.len : A 바꿔가면서 찾아내
    // 3. A.len < B.len : A 로 만들 수 있는 수중에 가장 큰 수가 답

    private static void backTrack(int[] temp, int depth, boolean alreadyBigger) {
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

            if (!visited[i]) {

            }
        }
    }

    private static int joinArr (int[] temp){
        int cur = 0;
        int location = temp.length;
        for (int i = 0; i < temp.length; i++) {
            if (location == 0) {
                cur += temp[temp.length - 1];
            }
            cur += (int) (temp[i] * Math.pow(10, location-- - 1));
        }
        return cur;
    }
}
