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
    private static int[][] resultGraph;

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
        resultGraph = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                resultGraph[i][j] = Integer.MAX_VALUE;
            }
        }

        int result = bfs(new Node(0, 0, 1, false));

        System.out.println(result);
    }
    // 최단 경로를 구해야 함이 적용되지 않음. 수정해야함
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
            resultGraph[x][y] = Math.min(resultGraph[x][y], node.depth);

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    if (graph[nx][ny] == 1  && node.breakChance) {
                        continue;
                    } else if (graph[nx][ny] == 1 && !node.breakChance) {
                        queue.offer(new Node(nx, ny, node.depth + 1, true));
                        continue;
                    }
                    queue.offer(new Node(nx, ny, node.depth + 1, node.breakChance));
                }
            }
        }

        if (!visited[N - 1][M - 1]) {
            return -1;
        } else {
            return resultGraph[N - 1][M - 1];
        }

    }

    private static class Node {
        int x, y, depth;
        boolean breakChance;

        public Node(int x, int y, int depth, boolean breakChance) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.breakChance = breakChance;
        }
    }
}
