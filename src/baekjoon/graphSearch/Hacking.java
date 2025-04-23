package baekjoon.graphSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hacking {
    private static List[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new List[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            arr[B].add(A);
        }


    }

    private static void dfs(int start) {

        for (List list : arr[start]) {

        }
    }
}
