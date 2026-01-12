package programmers.lv2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ForkliftAndCrane {
    private static String[][] arr;
    private static final int[] dx = {-1, 0, 0, 1};
    private static final int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] storage = sc.nextLine().split(", ");
        String[] requests = sc.nextLine().split(", ");

        System.out.println(solution(storage, requests));
    }

    private static int solution(String[] storage, String[] requests) {
        arr = new String[storage.length][storage[0].length()];
        for (int i = 0; i < storage.length; i++) {
            arr[i] = Arrays.stream(storage[i].split("")).toArray(String[]::new);
        }

        for (String s : requests) {
            if (s.length() == 1) {
                forklift(s);
            } else {
                crane(s.split("")[0]);
            }
        }

        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (!arr[i][j].equals("0")) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void forklift(String s) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

                if (arr[i][j].equals(s)) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || nx >= arr.length || ny < 0 || ny >= arr[0].length) {
                            arr[i][j] = "1";
                            break;
                        }
                    }
                } else {
                    if (arr[i][j].equals("0") &&
                            (i == 0 || j == 0 || i == arr.length - 1 || j == arr[0].length - 1)) {
                        bfs(i, j, s);
                    }
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j].equals("1")) {
                    arr[i][j] = "0";
                }
            }
        }
    }

    private static void bfs(int x, int y, String s) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        Deque<Node> q = new ArrayDeque<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || nx >= arr.length || ny < 0 || ny >= arr[0].length) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (arr[nx][ny].equals("0")){
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }

                if (arr[nx][ny].equals(s)) {
                    arr[nx][ny] = "1";
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static void crane(String s) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j].equals(s)) {
                    arr[i][j] = "0";
                }
            }
        }
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
