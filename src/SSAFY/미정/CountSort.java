package SSAFY.미정;

import java.util.Arrays;
import java.util.Scanner;

public class CountSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();;

            // 원본 배열
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            // 최대값
            int arrMaxValue = Arrays.stream(arr).max().orElseThrow();

            // 카운트 배열
            int[] cnt = new int[arrMaxValue + 1];
            for (int i = 0; i < N; i++) {
                cnt[arr[i]] += 1;
            }
            System.out.println(Arrays.toString(cnt));

            //누적합
            for (int i = 1; i <= arrMaxValue; i++) {
                cnt[i] += cnt[i - 1];
            }
            System.out.println(Arrays.toString(cnt));

            // 정렬
            int[] result = new int[N];
            for (int i = N - 1; i >= 0; i--) {
                int value = arr[i];
                result[cnt[value] - 1] = value;
                cnt[value]--;
            }

            System.out.println(Arrays.toString(result));
        }
    }
}
