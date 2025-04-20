package baekjoon.graphSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StartLink5014 {
    private static int F, S, G, U, D;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        F = sc.nextInt();   // 총 층수
        S = sc.nextInt();   // 시작 층
        G = sc.nextInt();   // 목적 층
        U = sc.nextInt();   // 위로 이동하는 층수
        D = sc.nextInt();   // 아래로 이동하는 층수

        visited = new boolean[F + 1];

        int result = bfs(S);

        if (result == -1) {
            System.out.println("use the stairs");
            return;
        }
        System.out.println(result);
    }

    private static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[]cur = queue.poll();
            int floor = cur[0];
            int cnt = cur[1];

            if (floor == G) {
                return cnt;
            }

            int up = floor + U;
            int down = floor - D;

            if (up <= F && !visited[up]) {
                visited[up] = true;
                queue.offer(new int[]{up, cnt + 1});
            }

            if (down >= 1 && !visited[down]) {
                visited[down] = true;
                queue.offer(new int[]{down, cnt + 1});
            }
        }
        return -1;
    }
}
