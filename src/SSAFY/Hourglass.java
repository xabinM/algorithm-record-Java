package SSAFY;

import java.util.ArrayList;
import java.util.List;

public class Hourglass {
    public static void main(String[] args) {
        int curNum = 1;
        int step = 2;
        int depth = 0;

        for (int i = 5; i >= 1; i -= step) {
            List<Integer> list = new ArrayList<>();

            if (depth != 0) {
                for (int j = depth; j > 0; j--) {
                    list.add(0);
                }
            }

            for (int k = 0; k < i; k++) {
                list.add(curNum++);
            }

            while (list.size() != 5){
                list.add(0);
            }

            depth += 1;

            printNum(list);
        }

        depth -= 1;

        for (int i = 3; i <= 5; i += step) {
            List<Integer> list = new ArrayList<>();

            if (--depth != 0) {
                for (int k = depth; k > 0; k--){
                    list.add(0);
                }
            }

            for (int j = 0; j < i; j++) {
                list.add(curNum++);
            }

            while (list.size() != 5){
                list.add(0);
            }

            printNum(list);
        }
    }

    private static void printNum(List<Integer> list) {
        for (int num : list) {
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
