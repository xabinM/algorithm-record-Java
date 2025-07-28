package baekjoon.graphSearch.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ZombieVirus {
    private static int N, M;
    private static int[][] graph;
    private static boolean[][] visited;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }


        visited = new boolean[N][M];
        while (true) {
            boolean flag = false;

            Deque<Node> nodes = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && (graph[i][j] == 1 || graph[i][j] == 2)) {
                        nodes.offer(new Node(i, j, graph[i][j]));
                        visited[i][j] = true;
                        flag = true;
                    }
                }
            }
            bfs(nodes);

            if (!flag) {
                break;
            }
        }

        int one = 0;
        int two = 0;
        int three = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                switch (graph[i][j]) {
                    case 1: one++;
                    break;
                    case 2: two++;
                    break;
                    case 3: three++;
                    break;
                }
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(one + " " + two + " " + three);
    }

    private static void bfs(Deque<Node> nodes) {
        while (!nodes.isEmpty()) {
            Node cur = nodes.poll();
            int x = cur.x;
            int y = cur.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= N || ny <0 || ny >= M) continue;
                
                if (!visited[nx][ny]) {
                    if (graph[nx][ny] == -1) {
                        continue;
                    }
                    if (graph[nx][ny] != 0) {
                        graph[nx][ny] = 3;
                    }
                    graph[nx][ny] = cur.value;
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static class Node {
        int x, y, value;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
