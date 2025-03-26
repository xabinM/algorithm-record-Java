package baekjoon.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Tomato {
    private static int M, N;
    private static int[][] box;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    static class Node {
        private final int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        sc.nextLine();

        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            box[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int result = bfs();

        System.out.println(result);
    }


    private static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 1) {
                    queue.offer(new Node(i, j));
                }
            }
        }

        int day = 0;

        while (!queue.isEmpty()) {
            for (int c = queue.size(); c > 0; c --){
                Node cur = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
            day++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    return -1;
                }
            }
        }

        return day - 1;
    }
}
