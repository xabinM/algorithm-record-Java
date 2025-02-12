package SSAFY;

import java.util.Scanner;

public class StringChecking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 0; t < 10; t++){
            int T = sc.nextInt();
            sc.nextLine();
            String check = sc.nextLine();
            String str = sc.nextLine();

            int result = (str.length() - str.replaceAll(check, "").length()) / check.length();

            System.out.println("#" + T + " " + result);
        }
    }
}
