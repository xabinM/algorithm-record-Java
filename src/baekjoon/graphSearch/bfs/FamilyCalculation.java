package baekjoon.graphSearch.bfs;

import java.util.*;

public class FamilyCalculation {
    private static int n, a, b, m;
    private static List<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x].add(y);
            graph[y].add(x);
        }

        System.out.println(bfs(a, b));
    }

    private static int bfs(int start, int end) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int man = cur[0];
            int cnt = cur[1];

            if (man == end) {
                return cnt;
            }

            for (int next : graph[man]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, cnt + 1});
                }
            }
        }

        return -1;
    }
}
