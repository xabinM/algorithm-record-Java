package baekjoon.avatar;

import java.util.Scanner;

public class RePaintingChess {
    private static String[][] chessBoard;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        chessBoard = new String[N][M];
        for (int i = 0; i < N; i++) {
            chessBoard[i] = sc.nextLine().split("");
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                result = Math.min(result, repaint(i, j));
            }
        }

        System.out.println(result);
    }

    private static int repaint(int x, int y) {
        int cntSW = 0;
        int cntSB = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String cur = chessBoard[i + x][j + y];

                if ((i + j) % 2 == 0) {
                    if (!cur.equals("W")) cntSW++;
                    if (!cur.equals("B")) cntSB++;
                } else {
                    if (!cur.equals("B")) cntSW++;
                    if (!cur.equals("W")) cntSB++;
                }
            }
        }

        return Math.min(cntSW, cntSB);
    }
}
