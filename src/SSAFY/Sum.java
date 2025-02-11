package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Sum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            int T = Integer.parseInt(br.readLine());

            int[][] graph = new int[100][100];
            for (int r = 0; r < 100; r++) {
                String[] temp = br.readLine().split(" ");
                for (int c = 0; c < 100; c++) {
                    graph[r][c] = Integer.parseInt(temp[c]);
                }
            }


            int leftCross = 0;
            int rightCross = 0;
            List<Integer> result = new ArrayList<>();

            for (int x = 0; x < 100; x++) {
                result.add(Arrays.stream(graph[x]).sum());
                int col = 0;
                for (int y = 0; y < 100; y++) {
                    col += graph[y][x];

                    if (x == y) {
                        leftCross += graph[x][y];
                    }
                    if (x + y == 99) {
                        rightCross += graph[x][y];
                    }
                }
                result.add(col);
            }

            result.add(leftCross);
            result.add(rightCross);
            int maxResult = Collections.max(result);

            System.out.println("#" + T + " " + maxResult);
        }
    }
}
