package baekjoon.permutation_combination;

import java.util.Scanner;

public class NAndM {
    static int N, M;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        permutation(0, new int[M], new boolean[N]);
    }

    private static void permutation(int depth, int[] arr, boolean[] visited) {
        if (depth == M) {
            for (int v : arr) {
                System.out.print(v + 1 + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                permutation(depth + 1, arr, visited);
                visited[i] = false;
            }
        }
    }
}
