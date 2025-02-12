package SSAFY.이차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Palindrome3 {
    private static final int TEST_CAST = 10;
    private static final int GRAPH_SIZE = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 0; t < TEST_CAST; t++) {
            int T = Integer.parseInt(br.readLine());

            String[][] graph = new String[GRAPH_SIZE][GRAPH_SIZE];
            for (int x = 0; x < GRAPH_SIZE; x++) {
                String[] temp = br.readLine().split("");
                for (int y = 0; y < GRAPH_SIZE; y++) {
                    graph[x][y] = temp[y];
                }
            }

            int longestStr = Integer.MIN_VALUE;

            for (int i = 0; i < GRAPH_SIZE; i++) {
                String[] col = new String[GRAPH_SIZE];
                for (int j = 0; j < GRAPH_SIZE; j++) {
                    col[j] = graph[j][i];
                    for (int k = GRAPH_SIZE; k >= j; k--) {
                        if (k - j > longestStr){
                            String[] tempRow = Arrays.copyOfRange(graph[i], j, k);
                            if (checkPalindrome(tempRow)) {
                                longestStr = Math.max(longestStr, tempRow.length);
                                break;
                            }
                        }
                    }
                }

                for (int p = GRAPH_SIZE; p >= i; p--) {
                    if (p - i > longestStr){
                        String[] tempCol = Arrays.copyOfRange(col, i, p);
                        if (checkPalindrome(tempCol)) {
                            longestStr = Math.max(longestStr, tempCol.length);
                            break;
                        }
                    }
                }
            }
            System.out.println("#" + T + " " + longestStr);
        }
    }

    private static boolean checkPalindrome(String[] str) {
        for (int i = 0; i < (str.length / 2); i++) {
            if (!str[i].equals(str[str.length - 1 - i])) {
                return false;
            }
        }
        return true;
    }
}
