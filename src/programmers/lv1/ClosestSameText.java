package programmers.lv1;

import java.util.Arrays;
import java.util.Scanner;

public class ClosestSameText {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(Arrays.toString(solution(sc.nextLine())));
    }

    public static int[] solution(String s) {
        int[] answer = new int[s.length()];

        String[] arr = s.split("");

        for (int i = 0; i < arr.length; i++) {
            int cnt = 0;
            boolean flag = false;

            for (int j = i; j >= 0 ; j--) {
                if (i == j) {
                    continue;
                }
                cnt++;

                if (arr[i].equals(arr[j])) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                answer[i] = -1;
                continue;
            }

            answer[i] = cnt;
        }

        return answer;
    }
}
