package programmers;

import java.util.Scanner;

public class Boxout {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int w = sc.nextInt();
        int num = sc.nextInt();

        System.out.println(solution(n, w, num));
    }

    public static int solution(int n, int w, int num) {

        int row = (n + w - 1) / w;
        int col = w;

        int[][] arr = new int[row][col];

        int cur = 1;

        int x = 0;
        int y = 0;

        f : for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {
                if (cur > n) {
                    break f;
                }

                if (i % 2 == 0) {
                    arr[i][j] = cur++;
                    if (cur - 1 == num) {
                        x = i;
                        y = j;
                    }
                } else {
                    arr[i][col - 1 - j] = cur++;
                    if (cur - 1 == num) {
                        x = i;
                        y = col - 1 - j;
                    }
                }
            }
        }

        int result = 0;

        while (true) {
            if (x == row) {
                break;
            }

            if (arr[x++][y] != 0) {
                result++;
            }
        }
        return result;
    }
}
