package SSAFY;

import java.util.Arrays;
import java.util.Scanner;

public class CountSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();;

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            int arrMaxValue = Arrays.stream(arr).max().orElseThrow();

            int[] cnt = new int[arrMaxValue + 1];
            for (int i = 0; i < N; i++) {
                cnt[arr[i]] += 1;
            }
            System.out.println(Arrays.toString(cnt));

            int[] result = new int[N];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < cnt.length; j++) {
                    if (cnt[j] != 0) {
                        result[i] = j;
                        cnt[j]--;
                        break;
                    }
                }
            }

            System.out.println(Arrays.toString(result));
        }
    }
}
