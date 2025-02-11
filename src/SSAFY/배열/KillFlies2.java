package SSAFY.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KillFlies2 {
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
            int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
            int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

            int result = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0 ; j < N; j++) {
                    int maxC = graph[i][j];
                    int maxX = graph[i][j];
                    for (int c = 0; c < 8; c++) {
                        for (int k = 1; k < M; k++) {
                            if (c < 4) {

                            } else {

                            }
                            int nx = i + dx[c] * k;
                            int ny = j + dy[c] * k;

                        }
//                            if (i + k != 0 && j + k != 0 && i -){
//                                maxC += graph[i + k][j] + graph[i][j + k] + graph[i - k][j] + graph[i][j - k];
//                                maxX += graph[i + k][j + k] + graph[i + k][j - k] + graph[i - k][j + k] + graph[i - k][j - k];
//                            }
                    }
                }
            }
        }
    }
}
