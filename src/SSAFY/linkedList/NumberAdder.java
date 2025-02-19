package SSAFY.linkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumberAdder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int L = sc.nextInt();
            sc.nextLine();

            LinkedList<Integer> arr = Arrays.stream(sc.nextLine().split(" ")).
                    map(Integer::parseInt).
                    collect(Collectors.toCollection(LinkedList::new));

            for (int i = 0; i < M; i++) {
                int idx = sc.nextInt();
                int num = sc.nextInt();

                arr.add(idx, num);
            }

            System.out.println("#" + t + " " + arr.get(L));
        }
    }
}
