package SSAFY;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElectricBus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int K = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();

            List<Integer> busStop = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                busStop.add(sc.nextInt());
            }

            int idx = 0;
            int cnt = 0;
            boolean flag = true;

            Outer : while (idx < N) {
                int temp = idx;
                for (int j = K; j >= 1; j--) {
                    if ((idx + K) >= N) {
                        break Outer;
                    }
                    if (busStop.contains(idx + j)) {
                        idx += j;
                        cnt += 1;
                        break;
                    }
                }
                if (temp == idx){
                    System.out.println("#" + t + " " + 0);
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.println("#" + t + " " + cnt);
            }
        }
    }
}
