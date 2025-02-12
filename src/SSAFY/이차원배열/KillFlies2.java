package SSAFY.이차원배열;

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
                    int sumC = graph[i][j];
                    int sumX = graph[i][j];
                    for (int c = 0; c < 8; c++) {
                        for (int k = 1; k < M; k++) {
                            int nx = i + dx[c] * k;
                            int ny = j + dy[c] * k;
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N){
                                if (c < 4) {
                                    sumC += graph[nx][ny];
                                } else {
                                    sumX += graph[nx][ny];
                                }
                            }
                        }
                    result = Math.max(result, Math.max(sumC, sumX));
                    }
                }
            }

            System.out.println("#" + t + " " + result);
        }
    }
}
