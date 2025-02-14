package SSAFY;

import java.util.Scanner;

public class MonotoneIncreasing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 0; i < N; i++) {
                int max = 0;
                for (int j = i; j < N; j++) {
                    if (arr[j] > arr[j + 1]) {
                        System.out.println("#" + t + " " + -1);

                    } else {

                    }
                }
            }
        }
    }
}
