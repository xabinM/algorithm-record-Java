package SSAFY;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t < 11; t++) {
            int N = sc.nextInt();

            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }

            int result = 0;
            for (int j = 2; j < (N - 2); j++) {
                int maxNeighbor = Math.max(
                        Math.max(arr.get(j - 2), arr.get(j - 1))
                        , Math.max(arr.get(j + 1), arr.get(j + 2))
                );

                if (maxNeighbor < arr.get(j)) {
                    result += arr.get(j) - maxNeighbor;
                }
            }

            System.out.println("#" + t + " " + result);
        }
    }
}
