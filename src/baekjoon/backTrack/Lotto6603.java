package baekjoon.backTrack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Lotto6603 {
    private static int k;
    private static int[] S;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            k = sc.nextInt();

            if (k == 0){
                return;
            }

            S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = sc.nextInt();
            }

            backTrack(0, 0, new ArrayDeque<>());
            System.out.println();
        }

    }

    private static void backTrack(int start, int depth, Deque<Integer> temp) {
        if (depth == 6) {
            for (int value : temp) {
                System.out.print(value + " ");
            }
            System.out.println();

            return;
        }


        for (int i = start; i < k; i++) {
            temp.add(S[i]);
            backTrack(i + 1, depth + 1, temp);
            temp.pollLast();
        }
    }
}