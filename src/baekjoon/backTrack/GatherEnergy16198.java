package baekjoon.backTrack;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GatherEnergy16198 {
    private static int maxEnergy;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        List<Integer> arr = Arrays.stream(sc.nextLine().split(" ")).
                map(Integer::parseInt).
                collect(Collectors.toList());

        maxEnergy = Integer.MIN_VALUE;

        backTrack(arr, 0);

        System.out.println(maxEnergy);
    }

    private static void backTrack(List<Integer> arr, int weight) {
        if (arr.size() <= 2) {
            maxEnergy = Math.max(maxEnergy, weight);
            return;
        }

        for (int i = 1; i < arr.size() - 1; i++) {
            int temp = arr.get(i);
            weight += arr.get(i - 1) * arr.get(i + 1);
            arr.remove(i);
            backTrack(arr, weight);
            arr.add(i, temp);
            weight -= arr.get(i - 1) * arr.get(i + 1);
        }
    }
}
