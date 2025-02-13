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

            boolean flag = false;

            Outer : for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (graph[i][j].equals("o")){
                        for (int k = 0; k < 8; k++) {
                            int cnt = 0;
                            for (int p = 1; p < 5; p++) {
                                int nx = i + dx[k] * p;
                                int ny = j + dy[k] * p;
                                if (nx < 0 || nx >= N || ny < 0 || ny >= N || !graph[nx][ny].equals("o")) {
                                    break;
                                }
                                cnt++;
                            }
                            if (cnt == 4) {
                                flag = true;
                                break Outer;
                            }
                        }
                    }
                }
            }
            if (flag) {
                System.out.println("#" + t + " " + "YES");
            } else {
                System.out.println("#" + t + " " + "NO");
            }
        }
    }
}
