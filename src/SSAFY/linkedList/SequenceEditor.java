package SSAFY.linkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SequenceEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int L = sc.nextInt();
            sc.nextLine();

            LinkedList<String> result = Arrays.stream(sc.nextLine().split(" ")).
                    collect(Collectors.toCollection(LinkedList::new));

            for (int i = 0; i < M; i++) {
                String[] edit = sc.nextLine().split(" ");
                if (edit.length == 2){
                    int idx = Integer.parseInt(edit[1]);
                    result.remove(idx);
                } else {
                    String order = edit[0];
                    int idx = Integer.parseInt(edit[1]);
                    String num = edit[2];

                    if (order.equals("I")) {
                        result.add(idx, num);
                    } else if (order.equals("C")) {
                        result.set(idx, num);
                    }
                }
            }
            System.out.print("#" + t + " ");
            if (result.size() <= L) {
                System.out.print(-1);
            } else {
                System.out.println(result.get(L));
            }
        }
    }
}
