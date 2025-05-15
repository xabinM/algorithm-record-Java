package baekjoon.graphSearch.bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class OneSheepTwoSheep11123 {
    private static int H, W;
    private static String[][] graph;
    private static boolean[][] visited;
    private static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            H = sc.nextInt();
            W = sc.nextInt();
            sc.nextLine();

            graph = new String[H][W];
            for (int i = 0; i < H; i++) {
                graph[i] = sc.nextLine().split("");
            }

            visited = new boolean[H][W];
            cnt = 0;

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (!visited[i][j] && graph[i][j].equals("#")) {
                        bfs(new Node(i, j));
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    private static void bfs(Node start) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.x][start.y] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;;
            int y = cur.y;;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                    if (!visited[nx][ny] && graph[nx][ny].equals("#")) {
                        queue.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        cnt++;
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
