package baekjoon.graphSearch.bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class NeedFriend21736 {
    private static int N, M;
    private static String[][] graph;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        graph = new String[N][M];
        for (int i = 0; i < N; i++) {
            graph[i] = sc.nextLine().split("");
        }

        int startX = 0;
        int startY = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j].equals("I")) {
                    startX = i;
                    startY = j;
                }
            }
        }

        visited = new boolean[N][M];

        int result = bfs(new Node(startX, startY));

        if (result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }

    private static int bfs(Node start) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.x][start.y] = true;

        int cnt = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >=0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && !graph[nx][ny].equals("X")) {
                        queue.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                        if (graph[nx][ny].equals("P")){
                            cnt++;
                        }
                    }
                }
            }

        }

        return cnt;
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
