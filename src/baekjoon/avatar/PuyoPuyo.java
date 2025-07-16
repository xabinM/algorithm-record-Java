package baekjoon.avatar;

import java.util.*;

public class PuyoPuyo {
    private static String[][] graph;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        graph = new String[12][6];
        for (int i = 0; i < 12; i++) {
            graph[i] = sc.nextLine().split("");
        }

        int cnt = 0;

        while (true) {
            boolean exploded = false;
            boolean[][] visited = new boolean[12][6];

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (!graph[i][j].equals(".") && !visited[i][j]) {
                        if (bfs(new Node(i, j), graph[i][j] ,visited)) {
                            exploded = true;
                        }
                    }
                }
            }

            if (!exploded) break;

            drop();
            cnt++;
        }

        System.out.println(cnt);
    }

    private static boolean bfs(Node start, String color ,boolean[][] visited) {
        Deque<Node> queue = new ArrayDeque<>();
        List<Node> temp = new ArrayList<>();
        boolean change = false;

        queue.offer(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;

            temp.add(cur);

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6) {
                    if (!visited[nx][ny] && graph[nx][ny].equals(color)){
                        visited[nx][ny] = true;
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
        }

        if (temp.size() >= 4) {
            for (Node node : temp) {
                graph[node.x][node.y] = ".";
            }
            change = true;
        }

        return change;
    }

    private static void drop() {
        for (int j = 0; j < 6; j++) {
            List<String> list = new ArrayList<>();
            for (int i = 11; i >= 0; i--) {
                if (!graph[i][j].equals(".")) {
                    list.add(graph[i][j]);
                }
            }

            for (int i = 11; i >= 0; i--) {
                if (11 - i < list.size()) {
                    graph[i][j] = list.get(11 - i);
                } else {
                    graph[i][j] = ".";
                }
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
