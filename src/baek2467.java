import java.util.Scanner;

import static java.lang.Math.abs;

public class baek2467 {
    public static void solution(int N, int[] liquid){
        int left = 0;
        int right = N - 1;
        int minSum = Integer.MAX_VALUE;
        int resultLeft = 0;
        int resultRight = 0;

        while (left < right){
            int current_sum = liquid[left] + liquid[right];

            if (abs(current_sum) < abs(minSum)){
                minSum = current_sum;
                resultLeft = left;
                resultRight = right;
            }

            if (current_sum < 0){
                left += 1;
            } else {
                right -= 1;
            }
        }
        System.out.println(liquid[resultLeft] + " " + liquid[resultRight]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] liquid = new int[N];

        for (int i = 0; i < N; i++){
            liquid[i] = scanner.nextInt();
        }

        scanner.close();
        solution(N, liquid);
    }
}
