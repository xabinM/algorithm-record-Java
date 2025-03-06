package baekjoon.backTrack;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GatherEnergy {
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
        }

        for (int i = 1; i < arr.size() - 1; i++) {
            int temp = arr.get(i);
            weight += arr.get(i - 1) * arr.get(i + 1);
            System.out.println("1 : " + arr);
            arr.remove(i);
            System.out.println("2 : " + arr);
            backTrack(arr, weight);
            arr.set(i, temp);
            System.out.println("3 : " + arr);
            weight -= arr.get(i - 1) * arr.get(i + 1);
        }
    }
}
