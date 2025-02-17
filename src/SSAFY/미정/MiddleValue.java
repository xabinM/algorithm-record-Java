package SSAFY.미정;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MiddleValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(sc.nextInt());
        }

        arr.sort(null);

        int middle = (N - 1) / 2;

        System.out.println(arr.get(middle));
    }
}
