package baekjoon.graphSearch.bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Shepherd3187 {
    private static int R, C;
    private static String[][] graph;
    private static boolean[][] visited;


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();

        graph = new String[R][C];
        for (int i = 0; i < R; i++) {
            graph[i] = sc.nextLine().split("");
        }

        visited = new boolean[R][C];

        int sheep = 0;
        int wolf = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && !graph[i][j].equals("#")) {
                    Result result = bfs(new Node(i, j));

                    if (result.who.equals("S")) {
                        sheep += result.cnt;
                    } else if (result.who.equals("W")){
                        wolf += result.cnt;;
                    }
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    private static Result bfs(Node start) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.x][start.y] = true;

        int sheepCnt = 0;
        int wolfCnt = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;

            if (graph[x][y].equals("v")) {
                wolfCnt += 1;
            } else if (graph[x][y].equals("k")) {
                sheepCnt += 1;
            }

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (!visited[nx][ny] && !graph[nx][ny].equals("#")) {
                        queue.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        if (sheepCnt > wolfCnt) {
            return new Result("S", sheepCnt);
        } else {
            return new Result("W", wolfCnt);
        }
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Result {
        String who;
        int cnt;

        public Result(String who, int cnt) {
            this.who = who;
            this.cnt = cnt;
        }
    }
}
