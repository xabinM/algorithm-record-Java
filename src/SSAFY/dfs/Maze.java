package SSAFY.dfs;

import java.util.Scanner;

public class Maze {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int N;
    private static String[][] maze;
    private static int result;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            sc.nextLine();

            maze = new String[N][N];
            for (int i = 0; i < N; i++) {
                maze[i] = sc.nextLine().split("");
            }
            result = 0;
            visited = new boolean[N][N];


            int[] startPoint = findStartPoint();
            int startX = startPoint[0];
            int startY = startPoint[1];

            if (startY == -1) {
                System.out.println("#" + t + " error");
                continue;
            }

            visited[startX][startY] = true;
            dfs(startX, startY);

            System.out.println("#" + t + " " + result);
        }
    }

    private static int[] findStartPoint() {
        int startX = -1;
        int startY = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (maze[i][j].equals("2")) {
                    startX = i;
                    startY = j;
                }
            }
        }
        return new int[]{startX, startY};
    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (maze[nx][ny].equals("3")) {
                    result = 1;
                    return;
                }

                if (maze[nx][ny].equals("0")) {
                    if (!visited[nx][ny]){
                        visited[nx][ny] = true;
                        dfs(nx, ny);
                        visited[nx][ny] = false;
                    }
                }
            }
        }
    }
}
