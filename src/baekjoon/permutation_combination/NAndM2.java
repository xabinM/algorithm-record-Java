package baekjoon.permutation_combination;

import java.util.Scanner;

public class NAndM2 {

    static int N, M;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        combination(0, 0, new int[M]);
    }

    static void combination(int start, int depth, int[] arr) {
        if (depth == M) {
            for (int v : arr) {
                System.out.print(v + 1 + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < N; i++) {
            arr[depth] = i;
            combination(i + 1, depth + 1, arr);
        }
    }
}
