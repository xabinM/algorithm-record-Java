package SSAFY.linkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();   // 원본 배열 길이
            int M = sc.nextInt();   // 숫자 추가할 처음 인덱스
            int K = sc.nextInt();   // 추가 반복 횟수
            sc.nextLine();

            LinkedList<Integer> ll = Arrays.stream(sc.nextLine().split(" ")).
                    map(Integer::parseInt).
                    collect(Collectors.toCollection(LinkedList::new));

            int idx = M;

            for (int i = 0; i < K; i++) {
                if (idx == 0){
                    ll.addLast(ll.getFirst() + ll.getLast());
                    idx = (idx + M - 1) % ll.size();
                } else {
                    ll.add(idx, ll.get(idx - 1) + ll.get(idx));
                    idx = (idx + M) % ll.size();
                }
            }

            System.out.print("#" + t + " ");
            if (ll.size() > 10){
                for (int i = (ll.size() - 1); i >= (ll.size() - 10); i--) {
                    System.out.print(ll.get(i) + " ");
                }
            } else {
                for (int i = (ll.size() - 1); i >= 0; i--) {
                    System.out.print(ll.get(i) + " ");
                }
            }
            System.out.println();
        }
    }
}
