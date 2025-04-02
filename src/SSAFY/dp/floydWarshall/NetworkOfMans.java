package SSAFY.dp.floydWarshall;

import java.util.Arrays;
import java.util.Scanner;

public class NetworkOfMans {
    private static final int INF = 999999999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();

            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                    if (i != j && arr[i][j] == 0) {
                        arr[i][j] = INF;
                    }
                }
            }

            int result = floydWarshall(N, arr);

            System.out.println("#" + t + " " + result);
        }
    }

    private static int floydWarshall(int N, int[][] arr) {

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                for (int k = 0; k < N; k++) {
                    arr[i][k] = Math.min(arr[i][k], arr[i][j] + arr[j][k]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            min = Math.min(min, Arrays.stream(arr[i]).sum());
        }

        return min;
    }
}
