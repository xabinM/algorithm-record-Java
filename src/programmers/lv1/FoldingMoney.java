package programmers.lv1;

import java.util.Arrays;
import java.util.Scanner;

public class FoldingMoney {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] wallet = Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] bill = Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(solution(wallet, bill));
    }

    public static int solution(int[] wallet, int[] bill) {

        int wMax = Math.max(wallet[0], wallet[1]);
        int wMin = Math.min(wallet[0], wallet[1]);
        int bMax = Math.max(bill[0], bill[1]);
        int bMin = Math.min(bill[0], bill[1]);

        int result = 0;

        while (true) {
            if (bMax <= wMax && bMin <= wMin) {
                break;
            }

            int temp = bMax / 2;

            if (temp < bMin) {
                bMax = bMin;
                bMin = temp;
            } else {
                bMax = temp;
            }
            result++;
        }

        return result;
    }
}
