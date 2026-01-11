package baekjoon.greedy;

import java.util.Scanner;

public class SumOfNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long S = sc.nextLong();

        long result = (long)((Math.sqrt(1 + 8.0 * S) - 1) / 2);

        System.out.println(result);
    }
}
