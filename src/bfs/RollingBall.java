package bfs;

import java.util.Scanner;

public class RollingBall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();

            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            int result = Integer.MIN_VALUE;

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    int cnt = bfs(arr, N, x, y);
                    if (cnt > result) {
                        result = cnt;
                    }
                }
            }
            System.out.println("#" + t + " " + (result + 1));
        }
    }

    private static int bfs(int[][] arr, int N, int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int curX = x;
        int curY = y;
        int preX = Integer.MAX_VALUE;
        int preY = Integer.MAX_VALUE;
        int cnt = 0;

        while (true) {

            int nextX = 0;
            int nextY = 0;
            int minValue = Integer.MAX_VALUE;
            boolean flag = false;

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N)  {
                    if (nx != preX || ny != preY) {
                        if (arr[nx][ny] < arr[curX][curY]) {
                            if (minValue > arr[nx][ny]){
                                flag = true;
                                minValue = arr[nx][ny];
                                nextX = nx;
                                nextY = ny;
                            }
                        }
                    }
                }
            }

            if (!flag) {
                break;
            } else {
                preX = curX;
                preY = curY;
                curX = nextX;
                curY = nextY;
                cnt += 1;
            }
        }
        return cnt;
    }
}
