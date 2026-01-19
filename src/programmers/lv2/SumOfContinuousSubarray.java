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
        LinkedList<int[]> result = new LinkedList<>();

        for (int i = 0; i < sequence.length; i++) {
            int[] temp = subarray(i, sequence, k);

            if (temp != null) {
                result.add(temp);
            }
        }

        if (result.size() == 1) {
            return result.getFirst();
        } else {
            return result.get(check(result));
        }
    }

    private static int check(List<int[]> result) {
        int idx = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < result.size(); i++) {
            int[] r = result.get(i);
            int temp = Math.min((r[1] - r[0]), min);

            if (min != temp) {
                idx = i;
                min = temp;
            }
        }

        return idx;
    }

    private static int[] subarray(int idx, int[] sequence, int k) {

        int[] result = new int[2];
        int sum = 0;
        boolean flag = false;

        for (int i = idx; i < sequence.length; i++) {
            sum += sequence[i];

            if (sum == k) {
                result[0] = idx;
                result[1] = i;
                flag = true;
                break;
            }
        }

        if (flag) {
            return result;
        } else {
            return null;
        }
    }
}
