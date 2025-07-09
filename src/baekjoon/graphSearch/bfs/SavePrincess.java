package baekjoon.graphSearch.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class SavePrincess {
    private static int N, M, T;
    private static int[][] graph;
    private static boolean[][][] visited;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();
        sc.nextLine();

        graph = new int[N][M];
        visited = new boolean[N][M][2]; // [x][y][0: 검 없음 / 1: 검 있음]
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        search(new Node(0, 0, 0, false));

        if (minTime == Integer.MAX_VALUE) {
            System.out.println("Fail");
        } else {
            System.out.println(minTime);
        }
    }

    private static void search(Node start) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.x][start.y][0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.curTime > T)
                continue;

            if (cur.x == N - 1 && cur.y == M - 1) {
                minTime = Math.min(minTime, cur.curTime);
                continue;
            }

            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                boolean nextSword = cur.sword || graph[nx][ny] == 2;
                int swordIdx = nextSword ? 1 : 0;

                if (visited[nx][ny][swordIdx])
                    continue;

                // 벽 통과 여부는 검이 있는 경우만 가능
                if (nextSword || graph[nx][ny] != 1) {
                    visited[nx][ny][swordIdx] = true;
                    queue.offer(new Node(nx, ny, cur.curTime + 1, nextSword));
                }
            }
        }
    }

    private static class Node {
        int x;
        int y;
        int curTime;
        boolean sword;

        public Node(int x, int y, int curTime, boolean sword) {
            this.x = x;
            this.y = y;
            this.curTime = curTime;
            this.sword = sword;
        }
    }
}
