package programmers.lv2;

import java.util.Stack;

public class CorrectParentheses {

    public static void main(String[] args) {

        String s = "(()(";

        System.out.println(solution(s));
    }

    public static boolean solution(String s) {

        Stack<Character> stack = new Stack<>();

        for (char cur : s.toCharArray()) {
            if (cur == ('(')) {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
