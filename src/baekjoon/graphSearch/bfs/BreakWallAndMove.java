package baekjoon.graphSearch.bfs;

import java.util.*;

public class BreakWallAndMove {
    private static int N;
    private static int M;
    private static int[][] graph;
    private static boolean[][][] visited; // 벽 부순 여부까지 체크하는 방문 배열

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

        visited = new boolean[N][M][2]; // 0: 벽 안 부숨, 1: 벽 부숨

        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        queue.offer(new Node(0, 0, 1, 0)); // 초기 상태: (0,0)에서 출발, depth=1, 벽 안 부숨
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int depth = node.depth;
            int breakChance = node.breakChance; // 0이면 벽 안 부숨, 1이면 부숨

            if (x == N - 1 && y == M - 1) {
                return depth; // 도착 시 depth 반환
            }

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (graph[nx][ny] == 0 && !visited[nx][ny][breakChance]) {
                        // 벽이 아니고 방문하지 않았으면 이동 가능
                        queue.offer(new Node(nx, ny, depth + 1, breakChance));
                        visited[nx][ny][breakChance] = true;
                    } else if (graph[nx][ny] == 1 && breakChance == 0 && !visited[nx][ny][1]) {
                        // 벽을 만나고 아직 안 부쉈으면 부수고 이동
                        queue.offer(new Node(nx, ny, depth + 1, 1));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }

        return -1; // 도착 못하면 -1 반환
    }

    private static class Node {
        int x, y, depth, breakChance;

        public Node(int x, int y, int depth, int breakChance) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.breakChance = breakChance;
        }
    }
}
