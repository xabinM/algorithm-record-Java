package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pulse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int[] array = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(solution(array));
    }

    public static int solution(int[] array) {
        int n = array.length;

        // 현재 연속 부분합
        int curSum1 = 0;
        int curSum2 = 0;

        // 현재까지 최대 부분합
        int result1 = Integer.MIN_VALUE;
        int result2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int pulse1 = (i % 2 == 0) ? 1 : -1;
            int value1 = array[i] * pulse1;
            curSum1 = Math.max(value1, curSum1 + value1);
            result1 = Math.max(result1, curSum1);

            int pulse2 = (i % 2 == 0) ? -1 : 1;
            int value2 = array[i] * pulse2;
            curSum2 = Math.max(value2, curSum2 + value2);
            result2 = Math.max(result2, curSum2);
        }

        return Math.max(result1, result2);
    }
}

