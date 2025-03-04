package SSAFY.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MatchingBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int tLen = Integer.parseInt(br.readLine());

            String[] strArr = br.readLine().split("");

            Stack<String> stack = new Stack<>();

            boolean isValid = true;

            for (String str : strArr) {
                if (str.equals("[") || str.equals("{") || str.equals("(") || str.equals("<")) {
                    stack.push(str);
                } else if (str.equals("]") || str.equals("}") || str.equals(")") || str.equals(">")) {
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    if (str.equals("]") && !stack.pop().equals("[") ||
                        str.equals("}") && !stack.pop().equals("{") ||
                        str.equals(")") && !stack.pop().equals("(") ||
                        str.equals(">") && !stack.pop().equals("<")) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid) {
               System.out.println("#" + t + " " + 1);
            } else {
                System.out.println("#" + t + " " + 0);

            }
        }
    }
}
