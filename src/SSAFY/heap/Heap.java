package SSAFY.heap;

import java.util.*;

public class Heap {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {

            int N = sc.nextInt();
            sc.nextLine();

            PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int[] temp = Arrays.stream(sc.nextLine().split(" ")).
                        mapToInt(Integer::parseInt).toArray();

                if (temp[0] == 1) {
                    heap.add(temp[1]);
                } else if (temp[0] == 2) {
                    if (heap.isEmpty()) {
                        result.add(-1);
                    } else {
                        result.add(heap.poll());
                    }
                }
            }
            System.out.print("#" + t + " ");
            for (int value : result) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
