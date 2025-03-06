package SSAFY.이진탐색;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeSort {
    private static int cnt;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            sc.nextLine();

            int[] arr = Arrays.stream(sc.nextLine().split(" ")).
                    mapToInt(Integer::parseInt).
                    toArray();

            cnt = 0;

            int[] result = mergeSort(arr);

            System.out.println("#" + t + " " + result[N / 2] + " " + cnt);
        }
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int midIdx = arr.length / 2;

        int[] lowArr = mergeSort(Arrays.copyOfRange(arr, 0, midIdx));
        int[] highArr = mergeSort(Arrays.copyOfRange(arr, midIdx, arr.length));

        if (lowArr[lowArr.length - 1] > highArr[highArr.length - 1]) {
            cnt++;
        }

        List<Integer> mergeArr = new ArrayList<>();

        int l = 0;
        int h = 0;

        while (l < lowArr.length && h < highArr.length) {
            if (lowArr[l] < highArr[h]) {
                mergeArr.add(lowArr[l]);
                l++;
            } else {
                mergeArr.add(highArr[h]);
                h++;
            }
        }

        for (int i = l; i < lowArr.length; i++) {
            mergeArr.add(lowArr[i]);
        }
        for (int i = h; i < highArr.length; i++) {
            mergeArr.add(highArr[i]);
        }

        return mergeArr.stream().
                mapToInt(Integer::intValue).
                toArray();
    }
}
