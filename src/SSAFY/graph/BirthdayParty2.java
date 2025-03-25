package SSAFY.graph;

import java.util.Scanner;

public class BirthdayParty2 {
    private static int[][] graph;
    private static boolean[] invited;
    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int M = sc.nextInt();

            graph = new int[n + 1][n + 1];
            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                graph[a][b] = b;
                graph[b][a] = a;
            }

            result = 0;
            invited = new boolean[n + 1];
            invited[0] = true;
            invited[1] = true;

            dfs(1, 0);

            System.out.println("#" + t + " " + result);
        }
    }

    private static void dfs(int curMan, int depth) {
        if (depth == 2) {
            return;
        }

        for (int friend : graph[curMan]) {
            if (friend != 0){
                if (!invited[friend]) {
                    invited[friend] = true;
                    result++;
                }
                dfs(friend, depth + 1);
            }
        }
    }
}
