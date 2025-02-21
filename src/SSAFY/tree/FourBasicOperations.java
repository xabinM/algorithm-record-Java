package SSAFY.tree;

import java.util.Scanner;

public class FourBasicOperations {
    private static String[] node;
    private static int[] leftC, rightC;
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            N = sc.nextInt();
            sc.nextLine();

            node = new String[N + 1];
            leftC = new int[N + 1];
            rightC = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                String[] temp = sc.nextLine().split(" ");
                node[i] = temp[1];

                if (temp.length == 4) {
                    leftC[i] = Integer.parseInt(temp[2]);
                    rightC[i] = Integer.parseInt(temp[3]);
                }
            }

            int result = inOrder(1);
            System.out.println("#" + t + " " + result);
        }
    }

    private static int inOrder(int idx) {
        if (idx > N) return 0;

        if (leftC[idx] == 0 || rightC[idx] == 0) {
            return Integer.parseInt(node[idx]);
        }

        int left = inOrder(leftC[idx]);
        int right = inOrder(rightC[idx]);

        return switch (node[idx]) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            case "/" -> left / right;
            default -> Integer.parseInt(node[idx]);
        };
    }
}
