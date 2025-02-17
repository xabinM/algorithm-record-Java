package SSAFY.미정;

import java.util.Arrays;
import java.util.Scanner;

public class FindPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            sc.nextLine();

            String[] strArr = sc.nextLine().split("");
            boolean isPalindrome = false;
            StringBuilder result = new StringBuilder();

            Outer : for (int i = 0; i <= N - M; i++) {
                for (int j = N; j >= (i + M); j--) {
                    String[] temp = Arrays.copyOfRange(strArr, i, j);

                    if (checkPalindrome(temp)) {
                        isPalindrome = true;
                        for (String str : temp) {
                            result.append(str);
                        }
                        break Outer;
                    }
                }
            }

            if (isPalindrome){
                System.out.println("#" + t + " " + result);
            } else {
                System.out.println("#" + t + " " + "NONE");
            }

        }
    }

    private static boolean checkPalindrome(String[] str) {
        for (int i = 0; i < (str.length / 2); i++) {
            if (!str[i].equals(str[str.length - 1 - i])) {
                return false;
            }
        }
        return true;
    }
}
