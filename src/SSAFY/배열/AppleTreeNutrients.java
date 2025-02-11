package SSAFY.배열;

import java.util.Scanner;

public class AppleTreeNutrients {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        int maxNutrients = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int temp = graph[i][j];
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        break;
                    }
                    temp += graph[nx][ny];
                }
                maxNutrients = Math.max(maxNutrients, temp);
            }
        }
        System.out.println(maxNutrients);
    }
}
