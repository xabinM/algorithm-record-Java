package SSAFY.미정;

import java.util.Scanner;

public class CompareString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int t = 1; t <= T; t++) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();

            if (str2.length() == str2.replace(str1, "").length()) {
                System.out.println("#" + t + " " + 0);
            } else {
                System.out.println("#" + t + " " + 1);
            }

        }
    }
}
