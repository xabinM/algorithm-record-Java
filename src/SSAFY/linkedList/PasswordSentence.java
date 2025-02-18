package SSAFY.linkedList;

import java.util.LinkedList;
import java.util.Scanner;

public class PasswordSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int N = sc.nextInt();
            sc.nextLine();

            String[] origin = sc.nextLine().split(" ");

            int M = sc.nextInt();
            sc.nextLine();

            String[] orders = sc.nextLine().split(" ");
            int idx = 0;

            LinkedList<String> result = new LinkedList<>();
            while (idx < orders.length) {
                if (orders[idx].equals("I")) {
                    int insertPos = Integer.parseInt(orders[idx + 1]);
                    int insertNum = Integer.parseInt(orders[idx + 2]);

                    for (int i = 0; i < N; i++) {
                        if (i == insertPos) {
                            int idx2 = 0;
                            for (int j = (idx + 3); j < (idx + insertNum + 3); j++) {
                                result.add(insertPos + idx2, orders[j]);
                                idx2++;
                            }
                        }
                        result.add(origin[i]);
                    }
                    idx += 3 + insertNum;
                }
            }
            System.out.print("#" + t + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
        }
    }
}
