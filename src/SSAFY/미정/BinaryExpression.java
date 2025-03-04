package SSAFY.미정;

import java.util.Scanner;

public class BinaryExpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();   // N번째 비트까지 확인할 것
            int M = sc.nextInt();   // 타겟 숫자

            for (int i = 1; i <= N; i++) {
                if (M % 2 == 0) {
                    System.out.println("#" + t + " OFF" );
                    break;
                }
                if (N == i) {
                    System.out.println("#" + t + " ON");
                    break;
                }
                M = M / 2;  // 수를 2로 나누면 이진법으로 봤을 때, 맨 오른쪽 수를 없앤다. -> 으로 한칸 이동함
            }
        }
    }
}
