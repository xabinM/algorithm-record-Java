package SSAFY.이차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KillFlies {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] temp = br.readLine().split(" ");
            int N = Integer.parseInt(temp[0]);
            int M = Integer.parseInt(temp[1]);

            int[][] graph = new int[N][N];
            for (int x = 0; x < N; x++) {
                String[] temp2 = br.readLine().split(" ");
                for (int y = 0; y < N; y++) {
                    graph[x][y] = Integer.parseInt(temp2[y]);
                }
            }


            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int curValue = 0;
                    Outer : for (int k = 0; k < M; k++) {
                        for (int p = 0; p < M; p++) {
                            if ((i + k) >= N || (j + p) >= N){
                                break Outer;
                            }
                            curValue += graph[i + k][j + p];
                        }
                    }
                    maxValue = Math.max(maxValue, curValue);
                }
            }
            System.out.println("#" + t + " " + maxValue);
        }
    }
}
