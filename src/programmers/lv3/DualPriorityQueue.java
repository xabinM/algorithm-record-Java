package programmers.lv3;

import java.util.ArrayList;
import java.util.List;

public class DualPriorityQueue {

    public static void main(String[] args) {

    }

    public int[] solution(String[] operations) {
        List<Integer> list = new ArrayList<>();

        for (String op : operations) {
            String[] temp = op.split(" ");
            String order = temp[0];
            String number = temp[1];

            if (order.equals("I")) {
                list.add(Integer.parseInt(number));
            } else if (order.equals("D") && number.equals("1")) {
                if (list.isEmpty()) {
                    continue;
                }

                list.remove(checkMax(list));
            } else if (order.equals("D") && number.equals("-1")) {
                if (list.isEmpty()) {
                    continue;
                }

                list.remove(checkMin(list));
            }
        }

        if (list.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{list.get(checkMax(list)), list.get(checkMin(list))};
        }
    }

    private static int checkMax(List<Integer> list) {
        int maxIdx = -1;

        if (list.isEmpty()) {
            return maxIdx;
        }

        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > maxValue) {
                maxIdx = i;
                maxValue = list.get(i);
            }
        }

        return maxIdx;
    }

    private static int checkMin(List<Integer> list) {
        int minIdx = -1;

        if  (list.isEmpty()) {
            return minIdx;
        }

        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i) < minValue) {
                minIdx = i;
                minValue = list.get(i);
            }
        }

        return minIdx;
    }
}
