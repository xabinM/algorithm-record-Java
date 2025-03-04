package SSAFY.stack;

import java.util.Scanner;
import java.util.Stack;

public class CuttingStealStick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int t = 1; t <= T; t++) {
            String[] brackets = sc.nextLine().split("");
            Stack<String> stack = new Stack<>();

            int result = 0;
            String pre = "";

            for (String str : brackets) {
                if (str.equals("(")) {
                    stack.push(str);
                    pre = str;
                } else {
                    stack.pop();
                    if (pre.equals(")")) {
                        result += 1;
                        pre = str;
                    } else {
                        result += stack.size();
                        pre = str;
                    }
                }
            }
            System.out.println("#" + t + " " + result);
        }
    }
}