package SSAFY;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SamsungBus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();

            List<List<Integer>> busRoutes = new ArrayList<>();
            for (int n = 0; n < N; n++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(sc.nextInt());
                temp.add(sc.nextInt());
                busRoutes.add(temp);
            }

            int P = sc.nextInt();

            int[] C = new int[P];
            for (int i = 0; i < P; i++) {
                C[i] = sc.nextInt();
            }

            int[] result = new int[P];

            for (List<Integer> route : busRoutes){
                for (int i = 0; i < P; i++) {
                    int station = C[i];
                    if (station >= route.get(0) && station <= route.get(1)){
                        result[i] += 1;
                    }
                }
            }

            System.out.print("#" + t + " ");
            for (int i = 0; i < P; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
    }
}
