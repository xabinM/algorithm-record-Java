package SSAFY.tree;

import java.util.Scanner;

public class InOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int N = sc.nextInt();
            sc.nextLine();

            String[] tree = new String[N + 1];
            for (int i = 0; i < N; i++){
                String[] input = sc.nextLine().split(" ");

                int idx = Integer.parseInt(input[0]);
                String value = input[1];

                tree[idx] = value;
            }

            System.out.print("#" + t + " ");
            inOrder(N, tree, 1);
            System.out.println();
        }
    }

    private static void inOrder(int N, String[] tree, int idx) {
        if (idx < N + 1) {
            inOrder(N, tree, idx * 2);
            System.out.print(tree[idx]);
            inOrder(N, tree, idx * 2 + 1);
        }
    }
}
