package programmers.lv3;

import java.util.Arrays;

public class Ranking {

    public static void main(String[] args) {

        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        System.out.println(solution(n, results));
    }

    public static int solution(int n, int[][] results) {

        boolean[][] graph = new boolean[n + 1][n + 1];

        for (int[] result : results) {
            graph[result[0]][result[1]] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int cnt = 0;

            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }

                if (graph[i][j] || graph[j][i]) {
                    cnt++;
                }
            }
            if (cnt == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}
