package SSAFY.미정;

import java.util.*;

public class MonotoneIncreasing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();

            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                numbers.add(sc.nextInt());
            }
//            System.out.println("원본 리스트! : " + numbers);

            int maxValue = -1;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    int number = numbers.get(i) * numbers.get(j);
                    if (isMonotoneIncreasing(number)) {
                        if (number > maxValue) {
                            maxValue = number;
                        }
                    }
                }
            }

//            System.out.println("곱한 값들! : " + multiply);


            System.out.println("#" + t + " " + maxValue);
        }
    }

    private static boolean isMonotoneIncreasing(int number) {
        char[] digits = String.valueOf(number).toCharArray();
        for (int i = 0; i < digits.length - 1; i++) {
            if (digits[i] > digits[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
