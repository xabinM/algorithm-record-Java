package SSAFY.미정;

import java.util.ArrayList;
import java.util.List;

public class RightAngledTriangle {
    public static void main(String[] args) {
        int curNum = 1;

        for (int i = 0; i < 5; i++) {
            List<Integer> temp = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                temp.add(0);
            }

            while (temp.size() < 5) {
                temp.add(curNum++);
            }

            for (int num : temp) {
                if (num == 0) {
                    System.out.print("  ");
                    continue;
                }
                System.out.print(num);
                System.out.print(" ");
            }
            System.out.println("\n");
        }
    }
}
