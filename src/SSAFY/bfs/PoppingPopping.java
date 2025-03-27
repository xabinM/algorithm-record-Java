package SSAFY.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PoppingPopping {
    private static int N;
    private static char[][] graph;
    private static final int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
    private static final int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            sc.nextLine();

            graph = new char[N][N];
            for (int i = 0; i < N; i++) {
                graph[i] = sc.nextLine().toCharArray();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] == '.') {
                        graph[i][j] = '0';
                        for (int k = 0; k < 8; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N && graph[nx][ny] == '*') {
                                graph[i][j] = '1';
                                break;
                            }
                        }
                    }
                }
            }

            visited = new boolean[N][N];
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && graph[i][j] == '0') {
                        cnt++;
                        bfs(new Node(i, j));
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && graph[i][j] == '1') {
                        cnt++;
                    }
                }
            }

            System.out.println("#" + t + " " + cnt);
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(start);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            int x = cur.x;
            int y = cur.y;
            visited[x][y] = true;

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    if (graph[nx][ny] == '0')
                        queue.offer(new Node(nx, ny));
                }
            }
        }
    }
}
