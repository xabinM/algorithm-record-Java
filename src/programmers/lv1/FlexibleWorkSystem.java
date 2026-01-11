package programmers.lv1;

import java.util.Arrays;
import java.util.Scanner;

public class FlexibleWorkSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] schedules = Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] timeLogs = new int[schedules.length][7];
        for (int i = 0; i < schedules.length; i++) {
            timeLogs[i] = Arrays.stream(sc.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int startDay = sc.nextInt();

        System.out.println(solution(schedules, timeLogs, startDay));
    }

    public static int solution(int[] schedules, int[][] timeLogs, int startDay) {

        int result = schedules.length;

        for (int i = 0; i < schedules.length; i++) {
            int curGoal = schedules[i];
            int[] curLogs = timeLogs[i];

            for (int j = 0; j < 7; j++) {
                int dayOfWeek = ((startDay - 1 + j) % 7) + 1;
                if ((dayOfWeek) == 6 || (dayOfWeek) == 7) {
                    continue;
                }

                if (!judge(curGoal, curLogs[j])) {
                    result--;
                    break;
                }
            }
        }

        return result;
    }

    public static boolean judge(int goal, int today) {
        int goalH = goal / 100;
        int goalM = goal % 100;
        int todayH = today / 100;
        int todayM = today % 100;

        int result =  (todayH * 60 + todayM) - (goalH * 60 + goalM);

        return result <= 10;
    }
}
