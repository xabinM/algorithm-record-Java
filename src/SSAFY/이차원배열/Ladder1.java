package SSAFY.이차원배열;

import java.io.*;

public class Ladder1 {
    private static final int TEST_CASE = 10;
    private static final int ARRAY_RANGE = 100;

    public static void main(String[] args) throws FileNotFoundException {

        try (BufferedReader br = new BufferedReader(new FileReader("resource/input.txt"))) {

            for (int t = 0; t < TEST_CASE; t++) {
                int T = Integer.parseInt(br.readLine());

                int[][] graph = new int[ARRAY_RANGE][ARRAY_RANGE];
                for (int x = 0; x < ARRAY_RANGE; x++) {
                    String[] temp = br.readLine().split(" ");
                    for (int y = 0; y < ARRAY_RANGE; y++) {
                        graph[x][y] = Integer.parseInt(temp[y]);
                    }
                }

                for (int i = 0; i < ARRAY_RANGE; i++) {
                    if (graph[0][i] == 1) {
                        int[] arrival = search(graph, 0, i);

                        if (graph[arrival[0]][arrival[1]] == 2) {

                            System.out.println("#" + T + " " + i);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("파일을 읽는 도중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    private static int[] search(int[][] graph, int startX, int startY) {
        int curX = startX;
        int curY = startY;

        while (curX < ARRAY_RANGE - 1) {
            // 한칸 내려가
            curX += 1;

            if (curY - 1 >= 0 && graph[curX][curY - 1] == 1) {
                while (curY - 1 >= 0 && graph[curX][curY - 1] == 1) {
                    curY -= 1;
                }
            } else if (curY + 1 < ARRAY_RANGE && graph[curX][curY + 1] == 1) {
                while (curY + 1 < ARRAY_RANGE && graph[curX][curY + 1] == 1) {
                    curY += 1;
                }
            }
        }
        return new int[]{curX, curY};
    }
}
