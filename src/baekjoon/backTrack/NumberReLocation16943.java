package baekjoon.backTrack;

import java.util.Scanner;

public class NumberReLocation16943 {
    private static int A;
    private static int B;
    private static String[] arr;
    private static int len;
    private static boolean[] visited;
    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();
        arr = String.valueOf(A).split("");
        len = arr.length;
        visited = new boolean[len];
        result = 0;



    }
    // A 랑 B의 자리수를 비교해서 분기를 3개로 쪼개야될듯?
    // 1. A.len > B.len : B보다 작아질 수 있는 수가 없기 때문에 -1 출력
    // 2. A.len = B.len : A 바꿔가면서 찾아내
    // 3. A.len < B.len : A 로 만들 수 있는 수중에 가장 큰 수가 답

    private static void backTrack(int[] temp, int depth) {

    }
}
