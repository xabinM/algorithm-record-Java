package baekjoon.graphSearch;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Sheep {
    private static int R, C;
    private static String[][] graph;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static boolean[][] visited;
    private static int totalSheep;
    private static int totalWolf;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();

        graph = new String[R][C];
        for (int i = 0; i < R; i++) {
            graph[i] = sc.nextLine().split("");
        }

        visited = new boolean[R][C];

        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++) {
                if (!graph[i][j].equals("#") && !visited[i][j]) {
                    bfs(new Node(i, j));
                }
            }
        }

        System.out.println(totalSheep + " " + totalWolf);
    }

    private static void bfs(Node start) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.x][start.y] = true;

        int sheepCnt = 0;
        int wolfCnt = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;

            if (graph[x][y].equals("o")) {
                sheepCnt++;
            }
            if (graph[x][y].equals("v")) {
                wolfCnt++;
            }

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny]) {
                    if (!graph[nx][ny].equals("#")) {
                        queue.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        if (sheepCnt > wolfCnt) {
            totalSheep += sheepCnt;
        } else {
            totalWolf += wolfCnt;
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
