package SSAFY.이진탐색;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MillionSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" ")).
                mapToInt(Integer::parseInt).
                toArray();

        int[] sortedArr = mergeSort(arr);

        System.out.println(sortedArr[sortedArr.length / 2]);
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int midIdx = arr.length / 2;

        int[] lowArr = mergeSort(Arrays.copyOfRange(arr, 0, midIdx));
        int[] highArr = mergeSort(Arrays.copyOfRange(arr, midIdx, arr.length));

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