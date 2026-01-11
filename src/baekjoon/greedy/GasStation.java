package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class GasStation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        long[] dist = Arrays.stream(sc.nextLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long[] cost = Arrays.stream(sc.nextLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        long minCost = cost[0];
        long minTotalCost = 0;
        for (int i = 0; i < N - 1; i++) {
            if (minCost > cost[i]) {
                minCost = cost[i];
            }
            minTotalCost += minCost * dist[i];
        }

        System.out.println(minTotalCost);
    }
}
