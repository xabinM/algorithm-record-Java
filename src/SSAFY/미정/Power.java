package SSAFY.미정;

import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int T = 0; T < 10; T++) {
            int t = sc.nextInt();

            int a = sc.nextInt(); // 밑
            int b = sc.nextInt(); // 지수

            int result = power(a, b);

            System.out.println("#" + t + " " + result);
        }
    }

    private static int power(int a, int b) {
        if (b == 0) {
            return 1;
        }

        return a * power(a,b - 1);
    }
}
