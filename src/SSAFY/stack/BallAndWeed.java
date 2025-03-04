package SSAFY.stack;

import java.util.Scanner;
import java.util.Stack;

public class BallAndWeed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int t = 1; t <= T; t++) {
            String str = sc.nextLine();

            int probablyBall = 0;


            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    char pre = stack.pop();
                    if (c == ')' && pre == '|') {
                        probablyBall += 1;
                    } else if (c == '|' && pre == '(') {
                        probablyBall += 1;
                    } else if (c == ')' && pre == '(') {
                        probablyBall += 1;
                    } else {
                        stack.push(c);
                    }
                }
            }
            System.out.println("#" + t + " " + probablyBall);
        }
    }
}
