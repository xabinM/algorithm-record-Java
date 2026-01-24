package programmers.lv2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class FindNextLargerNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = numbers.length - 1; i >= 0; i--) {

            if (stack.isEmpty()) {
                stack.push(numbers[i]);
                answer[i] = -1;
                continue;
            }

            if (stack.peek() <= numbers[i]) {
                while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    answer[i] = -1;
                } else {
                    answer[i] = stack.peek();
                }

                stack.push(numbers[i]);
                continue;
            }

            answer[i] = stack.peek();
            stack.push(numbers[i]);
        }

        return answer;
    }
}
