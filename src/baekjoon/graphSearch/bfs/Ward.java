package baekjoon.graphSearch.bfs;

import java.io.*;
import java.util.*;

public class Ward {
    private static int R, C;
    private static String[][] graph;

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new String[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = String.valueOf(line.charAt(j));
            }
        }

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken()) - 1;
        int sy = Integer.parseInt(st.nextToken()) - 1;

        String orders = br.readLine();

        List<Node> wardPositions = new ArrayList<>();

        for (int i = 0; i < orders.length(); i++) {
            char order = orders.charAt(i);
            switch (order) {
                case 'U':
                    sx--;
                    break;
                case 'D':
                    sx++;
                    break;
                case 'L':
                    sy--;
                    break;
                case 'R':
                    sy++;
                    break;
                case 'W':
                    wardPositions.add(new Node(sx, sy));
                    break;
            }
        }

        searchWard(wardPositions);

        graph[sx][sy] = ".";
        for (int k = 0; k < 4; k++) {
            int nx = sx + dx[k];
            int ny = sy + dy[k];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            graph[nx][ny] = ".";
        }

        StringBuilder sb = new StringBuilder();
        // 마지막에 시야 없는 곳 다 #처리
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!graph[i][j].equals(".")) {
                    graph[i][j] = "#";
                }
                sb.append(graph[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void searchWard(List<Node> startPositions) {
        boolean[][] visited = new boolean[R][C];
        Deque<Node> queue = new ArrayDeque<>();

        // 모든 W 좌표를 BFS 시작점으로 넣기
        for (Node start : startPositions) {
            if (visited[start.x][start.y]) continue;
            String target = graph[start.x][start.y];
            visited[start.x][start.y] = true;
            graph[start.x][start.y] = ".";
            queue.offer(start);

            bfs(queue, visited, target);
        }
    }

    private static void bfs(Deque<Node> queue, boolean[][] visited, String target) {
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (visited[nx][ny]) continue;
                if (!graph[nx][ny].equals(target)) continue;

                visited[nx][ny] = true;
                graph[nx][ny] = ".";
                queue.offer(new Node(nx, ny));
            }
        }
    }

    private static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
