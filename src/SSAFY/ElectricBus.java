package SSAFY;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElectricBus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int K = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();
            sc.nextLine();

            List<Integer> busStop = new ArrayList<>();
            for (int j = 0; j < M ; j++) {
                busStop.add(sc.nextInt());
            }
            sc.nextLine();


        }
    }
}
