package SSAFY;

import java.util.*;

public class PerfectShuffle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++){
            int N = sc.nextInt();
            sc.nextLine();

            String[] arr = sc.nextLine().split(" ");

            int mid = 0;
            if (N % 2 == 0) {
                mid = N / 2;
            } else {
                mid = (N + 1) / 2;
            }

            Deque<String> front = new LinkedList<>();
            Deque<String> back = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                if (i < mid) {
                    front.add(arr[i]);
                } else {
                    back.add(arr[i]);
                }
            }

            List<String> result = new ArrayList<>();
            while (result.size() != N) {
                if (!front.isEmpty()){
                    result.add(front.pollFirst());
                }
                if (!back.isEmpty()){
                    result.add(back.pollFirst());
                }
            }
            System.out.print("#" + t + " ");
            for (String str : result) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
