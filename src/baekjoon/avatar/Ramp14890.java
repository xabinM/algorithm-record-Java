package baekjoon.avatar;

import java.util.Arrays;
import java.util.Scanner;

public class Ramp14890 {
    private static int N, L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        sc.nextLine();

        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (check(graph[i])) {
                cnt += 1;
            }
            int[] col = new int[N];
            for (int j = 0; j < N; j++) {
                col[j] = graph[j][i];
            }
            if (check(col)) {
                cnt += 1;
            }
        }

        System.out.println(cnt);
    }

    private static boolean check(int[] arr) {
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            int diff = arr[i + 1] - arr[i];

            if (diff == 0) {
                continue;
            } else if (diff == 1) {
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || arr[j] != arr[i] || visited[j]) {
                        return false;
                    }
                    visited[j] = true;
                }
            } else if (diff == -1) {
                for (int j = i + 1; j <= i + L ; j++) {
                    if (j >= N || arr[j] != arr[i + 1] || visited[j]) {
                        return false;
                    }
                    visited[j] = true;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
