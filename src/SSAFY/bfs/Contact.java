package SSAFY.bfs;

import java.util.*;

public class Contact {
    private static List<Integer>[] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int N = sc.nextInt();
            int start = sc.nextInt();

            graph = new List[101];
            for (int i = 0; i < 101; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < N / 2; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                graph[u].add(v);
            }

            int result = bfs(start);

            System.out.println("#" + t + " " + result);
        }
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[101];
        int[] depth = new int[101];

        queue.offer(start);
        visited[start] = true;
        depth[start] = 0;

        int maxDepth = 0;
        int maxNode = start;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    depth[next] = depth[cur] + 1;
                    queue.offer(next);

                    if (depth[next] > maxDepth) {
                        maxDepth = depth[next];
                        maxNode = next;
                    } else if (depth[next] == maxDepth) {
                        maxNode = Math.max(maxNode, next);
                    }
                }
            }
        }
        return maxNode;
    }
}
