package SSAFY.backTrack;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumProductionPrice {
    private static int N;
    private static int[][] graph;
    private static boolean[] visited;
    private static int minPriceSum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t ++) {
            N = sc.nextInt();
            sc.nextLine();

            graph = new int[N][N];
            for (int i = 0; i < N; i++) {
                graph[i] = Arrays.stream(sc.nextLine().split(" ")).
                        mapToInt(Integer::parseInt).
                        toArray();
            }

            visited = new boolean[N];

            minPriceSum = Integer.MAX_VALUE;

            backTrack(0, 0);

            System.out.println("#" + t + " " + minPriceSum);
        }
    }

    private static void backTrack(int sumPrice, int depth) {
        if (sumPrice >= minPriceSum) {
            return;
        }

        if (depth == N) {
            minPriceSum = sumPrice;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]){
                visited[i] = true;
                backTrack(sumPrice + graph[depth][i], depth + 1);
                visited[i] = false;
            }
        }
    }
}
