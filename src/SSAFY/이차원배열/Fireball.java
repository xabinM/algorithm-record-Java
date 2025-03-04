package SSAFY.이차원배열;

import java.util.Scanner;

public class Fireball {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dxB = {-2, -2, -2, -1, -1, 0, 0, 0};
        int[] dyB = {-2, -1, 0, -2, 0, -2, -1, 0};

        int[] dxC = {-2, -2, -2, -2, -2, 2, 2, 2, 2, 2, -1, 0, 1, -1, 0, 1};
        int[] dyC = {-2, -1, 0, 1, 2, -2, -1, 0, 1, 2, -2, -2, -2, 2, 2, 2};

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();

            // 2차원 배열 입력 받기
            int[][] graph = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }

            int max = Integer.MIN_VALUE;

            // graph 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // A 장풍
                    max = Math.max(max, graph[i][j]);

                    // B 장풍
                    int bSum = 0;
                    for (int k = 0; k < 8; k++) {
                        int nxB = i + dxB[k];
                        int nyB = j + dyB[k];
                        if (nxB >= 0 && nxB < N && nyB >= 0 && nyB < N){
                            bSum += graph[nxB][nyB];
                        }
                    }
                    max = Math.max(max, bSum);

                    // C 장풍
                    int cSum = 0;
                    for (int k = 0; k < 16; k++) {
                        int nxC = i + dxC[k];
                        int nyC = j + dyC[k];

                        if (nxC >= 0 && nxC < N && nyC >= 0 && nyC < N){
                            cSum += graph[nxC][nyC];
                        }
                    }
                    max = Math.max(max, cSum);
                }
            }

            // 결과 출력
            System.out.println("#" + t + " " + max);
        }
    }
}
