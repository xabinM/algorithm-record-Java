package SSAFY.tree;

import java.util.Scanner;

public class BinarySearch {
    private static int value;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();

            int[] tree = new int[N + 1];

            value = 1;

            inOrder(N, tree, 1);
            System.out.print("#" + t + " ");
            System.out.print(tree[1] + " ");
            System.out.print(tree[N / 2]);
            System.out.println();
        }
    }

    private static void inOrder(int N, int[] tree, int idx) {
        if (idx < N + 1) {
            inOrder(N, tree, idx * 2);
            tree[idx] = value++;
            inOrder(N, tree, idx * 2 + 1);
        }
    }
}
