package baekjoon.graphSearch;

import java.util.Arrays;
import java.util.Scanner;

public class Laboratory {
    private static int N, M;
    private static int[][] graph;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        
    }
    
    private static void backtrack() {

        for (int i = 0; i <N; i++) {
            for (int j = 0; j < M; j++) {

            }
        }
    }
}
