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

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            int result = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {

                    if (graph[x][y].equals("1")){
                        for (int k = 0; k < 4; k++) {
                            int cnt = 0;
                            for (int p = 1; p < N; p++){
                                int nx = x + dx[k] * p;
                                int ny = y + dy[k] * p;
                                if (nx >= 0 && nx < N && ny >= 0 && ny < N && graph[nx][ny].equals("1")) {
                                    cnt++;
                                } else {
                                    break;
                                }
                            }
                            // 중간에 카운트 체크 상황 발생 시 반대 방향이 1인지 체크
                            // ex 1 1 1 1 일 때, 두 번째 1부터 오른쪽으로 카운트 한다면, 반대 방향이 1인지 체크해야함. (첫 번째도 1이므로 세칸이 아님)
                            int reverseDX = x + dx[k] * -1;
                            int reverseDY = y + dy[k] * -1;
                            if (reverseDX >= 0 && reverseDX < N && reverseDY >= 0 && reverseDY < N){
                                if (cnt == (K - 1) && !graph[reverseDX][reverseDY].equals("1")) {
                                    result++;
                                }
                            } else {
                                if (cnt == (K - 1)){
                                    result++;
                                }
                            }

                        }
                    }
                }
            }
            System.out.println("#" + t + " " + result / 2);
        }
    }
}
// 중복 체크 해야됨
// 반대 방향도 체크해야 됨 (1 1 1 1) 일 때, 2번째부터 오른쪽으로 탐색하면 카운트 하고 있지만 사실 왼쪽도 1이라 4칸짜리