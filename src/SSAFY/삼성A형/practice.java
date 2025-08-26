package SSAFY.삼성A형;

import java.util.Arrays;
import java.util.Scanner;

public class practice {
    private static int N, W, H;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {

            N = sc.nextInt();
            W = sc.nextInt();
            H = sc.nextInt();
            sc.nextLine();

            int[][] graph = new int[H][W];
            for (int i = 0; i < H; i++) {
                graph[i] = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            int result = dfs(0, graph);

            System.out.println("#" + t + " " + result);
        }
    }

    private static int dfs(int depth, int[][] graph) {
        int remain = sumBricks(graph);

        if (depth == N || remain == 0) {

            return remain;
        }

        int min = H * W;
        for (int i = 0; i < W; i++) {

            int[][] curGraph = new int[H][W];
            for (int j = 0; j < H; j++) {
                System.arraycopy(graph[j], 0, curGraph[j], 0, W);
            }

            int x = findX(i, curGraph);
            if (x == -1) continue;

            boom(x, i, curGraph);
            dropBlock(curGraph);

            min = Math.min(min, dfs(depth + 1, curGraph));
        }

        return (min == H * W) ? remain : min;
    }

    private static int sumBricks(int[][] graph) {
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (graph[i][j] != 0) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    private static int findX(int col, int[][] graph) {
        for (int i = 0; i < H; i++) {
            if (graph[i][col] != 0) {
                return i;
            }
        }
        return -1;
    }

    private static void boom(int x, int y, int[][] graph) {
        int spread = graph[x][y];
        graph[x][y] = 0;

        if (spread > 1) {
            for (int i = 1; i < spread; i++) {
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k] * i;
                    int ny = y + dy[k] * i;

                    if (nx < 0 || nx >= H || ny < 0 || ny >= W || graph[nx][ny] == 0) continue;

                    boom(nx, ny, graph);
                }
            }
        }
    }

    private static void dropBlock(int[][] graph) {
        for (int i = 0; i < W; i++) {

            for (int j = H - 1; j >= 0; j--) {
                if (graph[j][i] != 0) continue;

                for (int k = j - 1; k >= 0; k--) {
                    if (graph[k][i] == 0) continue;

                    graph[j][i] = graph[k][i];
                    graph[k][i] = 0;
                    break;
                }
            }
        }
    }
}
