package baekjoon.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PoppingPopping {
    private static int N;
    private static char[][] graph;
    private static final int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
    private static final int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};
    private static boolean[][] visited;
    private static int cnt;

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
        }

        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
        System.out.println();

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

        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
        System.out.println();

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && graph[i][j] == '0') {
                    cnt++;
                    bfs(i, j);
                }
            }
        }

        System.out.println("cnt : " + cnt);

        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
    }

    private static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.offer(new int[]{r, c});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
                    continue;
                visited[nx][ny] = true;
                if (graph[nx][ny] == '0')
                    q.offer(new int[]{nx, ny});
            }
        }
    }
}
