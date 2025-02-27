package SSAFY.삼성A형;

import java.util.Arrays;
import java.util.Scanner;

public class BreakBrick {
    private static int N;
    private static int W;
    private static int H;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();   // 구슬 쏘는 횟수
            W = sc.nextInt();   // 열
            H = sc.nextInt();   // 행
            sc.nextLine();

            int[][] graph = new int[H][W];
            for (int i = 0; i < H; i++) {
                int[] row = Arrays.stream(sc.nextLine().split(" ")).
                        mapToInt(Integer::parseInt).toArray();
                graph[i] = row;
            }


        }
    }

    private static int dfs(int[][] graph, int depth, int min) {
        if (depth == N) {
            return min;
        }

        for (int i = 0; i < N; i++) {
            int[][] nGraph = new int[H][W];
            for (int j = 0; j < H; j++){
                System.arraycopy(graph[j], 0, nGraph[j], 0, W);
            }


        }
    }

    private static int[][] boom(int[][] graph, int x, int y) {
        int spread = graph[x][y];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < spread; j++){
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;

                if (nx >= 0 && nx < W && ny >= 0 && ny < H) {
                    graph[x][y] = 0;
                    boom(graph, nx, ny);
                }
            }
        }

        return graph;
    }
}
