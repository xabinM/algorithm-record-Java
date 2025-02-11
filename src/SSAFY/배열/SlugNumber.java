package SSAFY.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SlugNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[][] slug = new int[N][N];

            int K = N;
            int dir = 1;
            int r = 0;
            int c = -1;
            int num = 1;

            while (true){
                for (int i = 0; i < K; i++) {
                    c += dir;
                    slug[r][c] = num;
                    num += 1;
                }

                K -= 1;

                if (K == 0) {
                    break;
                }

                for (int i = 0; i < K; i++) {
                    r += dir;
                    slug[r][c] = num;
                    num += 1;
                }

                dir *= -1;
            }

            System.out.println("#" + t);
            for (int[] row : slug) {
                for (int i = 0; i < N; i++) {
                    System.out.print(row[i] + " ");
                }
                System.out.println();
            }
        }
    }
}
