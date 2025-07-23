package baekjoon.avatar;

import java.util.Arrays;
import java.util.Scanner;

public class GettingSurfaceArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        int[][] paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            paper[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int surfaceArea = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int height = paper[i][j];
                if (height > 0) surfaceArea += 2; // top and bottom

                // 4 directions
                surfaceArea += Math.max(height - (i > 0 ? paper[i - 1][j] : 0), 0);
                surfaceArea += Math.max(height - (i < N - 1 ? paper[i + 1][j] : 0), 0);
                surfaceArea += Math.max(height - (j > 0 ? paper[i][j - 1] : 0), 0);
                surfaceArea += Math.max(height - (j < M - 1 ? paper[i][j + 1] : 0), 0);
            }
        }

        System.out.println(surfaceArea);
    }
}
