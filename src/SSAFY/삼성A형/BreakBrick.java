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

            int minBricks = H * W;
            int result = dfs(graph, 0, minBricks);

            System.out.println("#" + t + " " + result);
        }
    }

    private static int dfs(int[][] graph, int depth, int minBricks) {
        if (depth == N) {
            return Math.min(minBricks, sumBricks(graph));
        }
        // 열을 순차적으로 돔 (y 좌표가 주어짐)
        for (int y = 0; y < W; y++) {
            int[][] curGraph = new int[H][W];
            for (int j = 0; j < H; j++){
                System.arraycopy(graph[j], 0, curGraph[j], 0, W);
            }

            // 주어진 y 좌표가지고 맨 위에 있는 x 좌표를 찾아야지
            int x = findX(curGraph, y);

            // 해당 열이 전부 다 0이라면 다음 열 탐색
            if (x == -1) {
                continue;
            }
            boom(curGraph, x, y);       // 구슬 한번 떨어지고 난 후
            dropAllBrick(curGraph);     // 벽돌들 아래로 다 떨어드리고

            // depth 증가시켜서 dfs 또 진행
            minBricks = dfs(curGraph, depth + 1, minBricks);
        }
        return Math.min(minBricks, sumBricks(graph));
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

    // 벽돌 아래로 떨어뜨리기
    private static void dropAllBrick(int[][] graph) {
        for (int i = 0; i < W; i++) {
            for (int j = H - 1; j >= 0; j--) {
                if (graph[j][i] == 0){
                    for (int k = j - 1; k >= 0; k--) {
                        if (graph[k][i] != 0) {
                            int temp = graph[j][i];
                            graph[j][i] = graph[k][i];
                            graph[k][i] = temp;
                            break;
                        }
                    }
                }
            }
        }
    }

    // 그래프에서 맨 위에 있는 x좌표 찾는 메서드
    private static int findX(int[][] graph, int y) {
        for (int i = 0; i < H; i++) {
            if (graph[i][y] != 0) {
                return i;
            }
        }
        return -1;
    }

    // 구슬하나 떨어뜨렸을 때, 벽돌 부서지고 난 후의 graph 반환
    private static void boom(int[][] graph, int x, int y) {
        int spread = graph[x][y];
        graph[x][y] = 0;

        if (spread > 1){
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j < spread; j++) {
                    int nx = x + dx[i] * j;
                    int ny = y + dy[i] * j;

                    if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                        if (graph[nx][ny] != 0){
                            boom(graph, nx, ny);
                        }
                    }
                }
            }
        }
    }
}
