package baekjoon.avatar;

import java.util.*;

public class AC5430 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        tc: for (int t = 0; t < T; t++) {
            String commands = sc.nextLine();
            int n = sc.nextInt();
            sc.nextLine();
            String input = sc.nextLine();

            input = input.substring(1, input.length() - 1); // [] 제거
            Deque<Integer> deque = new ArrayDeque<>();

            if (n > 0) {
                String[] nums = input.split(",");
                for (String num : nums) {
                    deque.add(Integer.parseInt(num));
                }
            }

            boolean isReversed = false;

            for (char cmd : commands.toCharArray()) {
                if (cmd == 'R') {
                    isReversed = !isReversed;
                } else if (cmd == 'D') {
                    if (deque.isEmpty()) {
                        System.out.println("error");
                        continue tc;
                    }
                    if (isReversed) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while (!deque.isEmpty()) {
                sb.append(isReversed ? deque.pollLast() : deque.pollFirst());
                if (!deque.isEmpty()) sb.append(",");
            }
            sb.append("]");
            System.out.println(sb);
        }
    }
}
