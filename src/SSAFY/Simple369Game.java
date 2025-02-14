package SSAFY;

import java.util.Arrays;
import java.util.Scanner;

public class Simple369Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            String[] strArr = String.valueOf(i).split("");

            StringBuilder result = new StringBuilder();
            boolean isNormal = true;
            int cnt369 = 0;

            for (String str : strArr) {
                if (str.equals("3") || str.equals("6") || str.equals("9")) {
                    isNormal = false;
                    cnt369++;
                }
            }

            if (isNormal) {
                for (String string : strArr) {
                    result.append(string);
                }
            } else {
                for (int j = 0; j < cnt369; j++) {
                    result.append("-");
                }
            }
            System.out.print(result + " ");
        }
    }
}
