package SSAFY.미정;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int t = 1; t <= T; t++) {
            String[] str = sc.nextLine().split("");
            boolean flag = true;

            for (int i = 0; i < str.length; i++) {
                if (!str[i].equals(str[str.length - 1 - i])) {
                    System.out.println("#" + t + " " + 0);
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.println("#" + t + " " + 1);
            }
        }
    }
}
