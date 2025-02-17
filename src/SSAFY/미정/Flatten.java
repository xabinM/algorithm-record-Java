package SSAFY.미정;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flatten {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int dumpCount = sc.nextInt();
            sc.nextLine();

            List<Integer> arr = Stream.of(sc.nextLine().split(" ")).
                    map(Integer::parseInt).
                    collect(Collectors.toList());

            for (int i = 0; i < dumpCount; i++) {
                int minIndex = 0;
                int maxIndex = 0;

                for (int j = 0; j < arr.size(); j++) {
                    if (arr.get(j) < arr.get(minIndex)) {
                        minIndex = j;
                    }

                    if (arr.get(j) > arr.get(maxIndex)) {
                        maxIndex = j;
                    }
                }

                arr.set(minIndex, arr.get(minIndex) + 1);
                arr.set(maxIndex, arr.get(maxIndex) - 1);

                if (arr.get(maxIndex) - arr.get(minIndex) <= 1) {
                    break;
                }
            }

            int result = Collections.max(arr) - Collections.min(arr);

            System.out.println("#" + t + " " + result);
        }
    }
}
