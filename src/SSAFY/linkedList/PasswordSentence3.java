package SSAFY.linkedList;

import java.util.LinkedList;
import java.util.Scanner;

public class PasswordSentence3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int N = sc.nextInt();
            sc.nextLine();
            // 이거 수정해야함. 원본을 애초부터 링크드리스트로 갖고 있고 거기에 I, D, A를 해야함
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
                } else if (orders[idx].equals("D")) {
                    int deleteStartPos = Integer.parseInt(orders[idx + 1]);
                    int deleteNum = Integer.parseInt(orders[idx + 2]);

                    for (int i = 0; i < deleteNum; i++) {
                        // 그냥 deleteStartPos를 deleteNum 번 만큼 지우면 됨 인덱스 변경 없음 어차피 지우면 당겨짐
                    }
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
