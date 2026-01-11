package baekjoon.graphSearch.bfs;

import java.util.*;

public class Cheeze {

    private static int R, C;
    private static int[][] graph;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();

        graph = new int[R][C];
        for (int i = 0; i < R; i++) {
            graph[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int cnt = 0;
        int lastCheezeCnt = 0;

        while (true) {
            boolean[][] outside = markOutsideAir();
            List<Node> cheezes = search(outside);

            if (cheezes.isEmpty()) {
                break;
            }

            cnt++;
            lastCheezeCnt = cheezes.size();

            for (Node node : cheezes) {
                graph[node.x][node.y] = 0;
            }

        }
        System.out.println(cnt);
        System.out.println(lastCheezeCnt);
    }

    private static List<Node> search(boolean[][] outside) {
        List<Node> temp = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                Node cur = new Node(i, j);

                if (graph[i][j] == 1 && isTouchAir(cur, outside)) {
                    temp.add(cur);
                }
            }
        }

        return temp;
    }

    static boolean[][] markOutsideAir() {
        boolean[][] outside = new boolean[R][C];
        Deque<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0));
        outside[0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (!in(nx, ny) || outside[nx][ny]) continue;

                if (graph[nx][ny] == 0) {
                    outside[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }
            }
        }

        return outside;
    }

    private static boolean isTouchAir(Node node, boolean[][] outside) {
        for (int k = 0; k < 4; k++) {
            int nx = node.x + dx[k];
            int ny = node.y + dy[k];

            if (in(nx, ny) && outside[nx][ny]) {

                return true;
            }
        }
        return false;
    }

    private static boolean in(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
