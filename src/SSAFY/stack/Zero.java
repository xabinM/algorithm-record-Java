package SSAFY.stack;

import java.util.Scanner;
import java.util.Stack;

public class Zero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {
            int K = sc.nextInt();

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < K; i++) {
                int price = sc.nextInt();

                if (!stack.isEmpty() && price == 0) {
                    stack.pop();
                } else if (price != 0) {
                    stack.push(price);
                }
            }
            int result = stack.stream().mapToInt(Integer::intValue).sum();

            System.out.println("#" + t + " " + result);
        }
    }
}
