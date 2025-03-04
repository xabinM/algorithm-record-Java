package SSAFY.stack;

import java.util.Scanner;
import java.util.Stack;

public class test_03_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int t = 1; t <= T; t++) {
            String[] S = sc.nextLine().split("");

            Stack<String> stack = new Stack<>();

            // 맞는 짝 찾기
            for (String s : S) {
                if (stack.isEmpty()) {
                    stack.push(s);
                } else if (s.equals(">") && stack.peek().equals("<")) {
                    stack.pop();
                } else if (s.equals(")") && stack.peek().equals("(")) {
                    stack.pop();
                } else if (s.equals("}") && stack.peek().equals("{")) {
                    stack.pop();
                } else if (s.equals("]") && stack.peek().equals("[")) {
                    stack.pop();
                } else {
                    stack.push(s);
                }
            }

            // 출력 사항1 문자열의 짝이 다 맞으면 1출력
            System.out.print("#" + t + " ");
            if (stack.isEmpty()) {
                System.out.println(1);
                continue;
            }
            // 원래의 stack size 변수 저장
            int originStackSize = stack.size();

            // 짝이 안맞는 녀석들 맞는 짝 출력하기 위한 results 생성 및 값 저장
            Stack<String> results = new Stack<>();
            for (int i = 0; i < originStackSize; i++) {
                if (stack.peek().equals("<")) {
                    results.add(">");
                    stack.pop();
                } else if (stack.peek().equals("(")) {
                    results.add(")");
                    stack.pop();
                } else if (stack.peek().equals("{")) {
                    results.add("}");
                    stack.pop();
                } else if (stack.peek().equals("[")) {
                    results.add("]");
                    stack.pop();
                } else {
                    results.clear();
                    results.add("0");
                    break;
                }
            }

            //출력
            for (String result : results) {
                System.out.print(result);
            }
            System.out.println();
        }
    }
}
