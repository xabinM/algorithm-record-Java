package SSAFY.미정;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PassWordMaker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        for (int t = 0; t < 10; t++) {
            int T = sc.nextInt();
            Deque<Integer> deq = new ArrayDeque<>();
            for (int i = 0; i < 8; i++) {
                deq.add(sc.nextInt());
            }


            Outer : while (true) {
                for (int i = 1; i <= 5; i++) {
                    int first = deq.pollFirst();
                    if (first - i <= 0) {
                        deq.addLast(0);
                        break Outer;
                    }
                    deq.addLast(first - i);
                }
            }

            System.out.print("#" + T + " ");
            for (int value : deq) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
