package programmers.lv2;

public class Delivery {

    public static void main(String[] args) {

        int N = 5;
        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int K = 3;

        System.out.println(solution(N, road, K));

    }

    public static int solution(int N, int[][] road, int K) {

        int[][] graph = new int[N + 1][N + 1];

        int INF =  Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                graph[i][j] = (i == j) ? 0 : INF;
            }
        }

        for (int[] info : road) {
            int start = info[0];
            int end = info[1];
            int time = info[2];

            graph[start][end] = Math.min(graph[start][end], time);
            graph[end][start] = Math.min(graph[end][start], time);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][k] != INF && graph[k][j] != INF) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (graph[1][i] <= K) {
                result++;
            }
        }

        return result;
    }
}
