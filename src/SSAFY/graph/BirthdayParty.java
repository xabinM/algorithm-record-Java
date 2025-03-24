package SSAFY.graph;

import java.util.Scanner;

public class BirthdayParty {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int M = sc.nextInt();

            int[][] graph = new int[n + 1][n + 1];
            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                graph[a][b] = b;
                graph[b][a] = a;
            }

            int result = 0;
            boolean[] invited = new boolean[n + 1];
            invited[0] = true;
            invited[1] = true;

            for (int friend : graph[1]) {
                if (!invited[friend]) {
                    result++;
                    invited[friend] = true;
                }
                for (int friendOfFriend : graph[friend]) {
                    if (!invited[friendOfFriend]) {
                        result++;
                        invited[friendOfFriend] = true;
                    }
                }
            }

            System.out.println("#" + t + " " + result);
        }
    }
}
