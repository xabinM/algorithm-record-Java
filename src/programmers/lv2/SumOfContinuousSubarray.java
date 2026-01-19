package programmers.lv2;

import java.util.*;

public class SumOfContinuousSubarray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] sequence = Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int k = sc.nextInt();

        System.out.println(Arrays.toString(solution(sequence, k)));
    }

    public static int[] solution(int[] sequence, int k) {
        int left = 0, right = 0;
        int sum = sequence[0];
        int bestL = 0, bestR = Integer.MAX_VALUE;

        while (left <= right && right < sequence.length) {
            if (sum == k) {
                if ((bestR - bestL) > (right - left)) {
                    bestL = left;
                    bestR = right;
                }
                sum -= sequence[left++];
            } else if (sum < k) {
                right++;
                if (right < sequence.length) {
                    sum += sequence[right];
                }
            } else {
                sum -= sequence[left++];
            }
        }

        return new int[]{bestL, bestR};
    }
}
