package SSAFY.이차원배열;

import java.util.Arrays;
import java.util.Scanner;

public class Concave {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            sc.nextLine();

            String[][] graph = new String[N][N];
            for (int x = 0; x < N; x++) {
                graph[x] = sc.nextLine().split("");
            }

            int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
            int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (graph[i][j].equals("o")){
                        for (int k = 0; k < 8; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                if (graph[nx][ny].equals("o")) {

                                }
                            }
                        }
                    }
                }
            }

        }
    }
}
