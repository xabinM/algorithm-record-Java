package SSAFY.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class EasyChange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();

            int[] moneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

            int[] result = new int[8];

            for (int i = 0; i < 8; i++) {
                result[i] = N / moneys[i];
                N = N % moneys[i];
            }

            System.out.println("#" + t);
            for (int v : result) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
