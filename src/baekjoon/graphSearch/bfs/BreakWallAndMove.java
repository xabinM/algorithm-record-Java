package baekjoon.graphSearch.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class BreakWallAndMove {
    private static int N;
    private static int M;
    private static int[][] graph;
    private static boolean[][] visited;
    private static boolean breakChance = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(sc.nextLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        visited = new boolean[N][M];

        bfs(new Node(0, 0, 1));

    }

    private static int bfs(Node start) {
        Queue<Node> queue = new ArrayDeque<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        queue.offer(start);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            visited[x][y] = true;
            graph[x][y] = node.depth;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    if (graph[nx][ny] == 1  && breakChance) {
                        continue;
                    } else if (graph[nx][ny] == 1 && !breakChance) {
                        breakChance = true;
                    }
                    queue.offer(new Node(nx, ny, node.depth + 1));
                }
            }
        }

        if (!visited[N - 1][M - 1]) {
            return -1;
        } else {
            return graph[N - 1][M - 1];
        }

    }

    private static class Node {
        int x, y, depth;

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
        }
    }
}
