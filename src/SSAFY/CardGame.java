package SSAFY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CardGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] arrN = new int[N];
            for (int i = 0; i < N; i++) {
                arrN[i] = i + 1;
            }

            int[] arrM = new int[M];
            for (int i = 0; i < M; i++) {
                arrM[i] = i + 1;
            }

            int[] sumCount = new int[N + M + 1];
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int sum = arrN[i] + arrM[j];
                    sumCount[sum] += 1;
                }
            }

            List<Integer> results = new ArrayList<>();
            int maxValue = Arrays.stream(sumCount).max().orElse(0);
            for (int i = 0; i < sumCount.length; i++) {
                if (sumCount[i] == maxValue) {
                    results.add(i);
                }
            }

            //출력
            System.out.print("#" + t + " ");
            for (int result : results) {
                System.out.print(result + " ");
            }
            System.out.println();
        }
    }
}
