package SSAFY.이차원배열;

import java.util.Arrays;
import java.util.Scanner;

public class WhereCanWordGoIn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            sc.nextLine();

            String[][] graph = new String[N][N];
            for (int i = 0; i < N; i++) {
                graph[i] =  sc.nextLine().split(" ");
            }

            int result = 0;

            for (int x = 0; x < N; x++) {
                int cnt = 0;
                for (int y = 0; y < N; y++) {
                    if (graph[x][y].equals("1")) {
                        cnt++;
                    } else {
                        if (cnt == K) {
                            result++;
                        }
                        cnt = 0;
                    }
                }
                if (cnt == K) {
                    result++;
                }
            }

            for (int y = 0; y < N; y++) {
                int cnt = 0;
                for (int x = 0; x < N; x++) {
                    if (graph[x][y].equals("1")) {
                        cnt++;
                    } else {
                        if (cnt == K) {
                            result++;
                        }
                        cnt = 0;
                    }
                }
                if (cnt == K) {
                    result++;
                }
            }


            System.out.println("#" + t + " " + result);
        }
    }
}
// 중복 체크 해야됨
// 반대 방향도 체크해야 됨 (1 1 1 1) 일 때, 2번째부터 오른쪽으로 탐색하면 카운트 하고 있지만 사실 왼쪽도 1이라 4칸짜리