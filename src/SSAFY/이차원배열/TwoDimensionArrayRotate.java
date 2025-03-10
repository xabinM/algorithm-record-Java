package SSAFY.이차원배열;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDimensionArrayRotate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(sc.nextLine().split(" ")).
                    mapToInt(Integer::parseInt).
                    toArray();
        }

        for (int i = 0; i < K; i++) {
            arr = rotate(arr);
        }

        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static int[][] rotate(int[][] arr) {
        int rowLen = arr.length;
        int colLen = arr[0].length;

        int[][] result = new int[colLen][rowLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                result[j][rowLen - 1 - i] = arr[i][j];
            }
        }
        return result;
    }
}
