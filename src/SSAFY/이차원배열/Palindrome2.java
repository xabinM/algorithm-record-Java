package SSAFY.이차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome2 {
    private static final int TEST_CAST = 10;
    private static final int GRAPH_SIZE = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= TEST_CAST; t++) {
            int palLength = Integer.parseInt(br.readLine());

            String[][] graph = new String[GRAPH_SIZE][GRAPH_SIZE];
            for (int x = 0; x < GRAPH_SIZE; x++) {
                String[] temp = br.readLine().split("");
                for (int y = 0; y < GRAPH_SIZE; y++) {
                    graph[x][y] = temp[y];
                }
            }

            int cnt = 0;
            for (int x = 0; x < GRAPH_SIZE; x++) {
                for (int y = 0; y < GRAPH_SIZE; y++) {
                    StringBuilder rowStr = new StringBuilder();
                    StringBuilder colStr = new StringBuilder();
                    for (int m = 0; m < palLength; m++) {
                        int nx = x + m;
                        int ny = y + m;
                        if (ny >= 0 && ny < GRAPH_SIZE) {
                            rowStr.append(graph[x][ny]);
                        }
                        if (nx >= 0 && nx < GRAPH_SIZE){
                            colStr.append(graph[nx][y]);
                        }
                    }
                    if (rowStr.length() == palLength) {
                        if (checkPalindrome(String.valueOf(rowStr))) {
                            cnt += 1;
                        }
                    }
                    if (colStr.length() == palLength) {
                        if (checkPalindrome(String.valueOf(colStr))) {
                            cnt += 1;
                        }
                    }
                }
            }
            System.out.println("#" + t + " " + cnt);
        }
    }

    private static boolean checkPalindrome(String str) {
        String[] strArr = str.split("");

        for (int i = 0; i < (str.length() / 2); i++) {
            if (!strArr[i].equals(strArr[str.length() - 1 - i])) {
                return false;
            }
        }
        return true;
    }
}
