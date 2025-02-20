package SSAFY.linkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PasswordSentence3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int N = sc.nextInt();
            sc.nextLine();

            LinkedList<String> origin = Arrays.stream(sc.nextLine().split(" ")).
                    collect(Collectors.toCollection(LinkedList::new));

            int M = sc.nextInt();
            sc.nextLine();

            String[] orders = sc.nextLine().split(" ");
            int idx = 0;

            while (idx < orders.length) {
                if (orders[idx].equals("I")) {
                    int insertPos = Integer.parseInt(orders[idx + 1]);
                    int insertNum = Integer.parseInt(orders[idx + 2]);

                    int idx2 = 0;
                    for (int j = (idx + 3); j < (idx + 3 + insertNum); j++) {
                        origin.add(insertPos + idx2, orders[j]);
                        idx2++;
                    }

                    idx += 3 + insertNum;
                }
                else if (orders[idx].equals("D")) {
                    int deleteStartPos = Integer.parseInt(orders[idx + 1]);
                    int deleteCnt = Integer.parseInt(orders[idx + 2]);

                    for (int i = 0; i < deleteCnt; i++) {
                        // 그냥 deleteStartPos를 deleteNum 번 만큼 지우면 됨 인덱스 변경 없음 어차피 지우면 당겨짐
                        origin.remove(deleteStartPos);
                    }
                    idx += 3;
                } else if (orders[idx].equals("A")) {
                    int addCnt = Integer.parseInt(orders[idx + 1]);

                    for (int i = (idx + 2); i < (idx + 2 + addCnt); i++) {
                        origin.add(orders[i]);
                    }
                    idx += 2 + addCnt;
                }

            }
            System.out.print("#" + t + " ");
            if (origin.size() > 10){
                for (int i = 0; i < 10; i++) {
                    System.out.print(origin.get(i) + " ");
                }
            } else {
                for (String value : origin) {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
        }
    }
}
