package programmers;

import java.util.Arrays;
import java.util.Scanner;

public class VideoPlayer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String result = solution(sc.nextLine(), sc.nextLine(), sc.nextLine(),
                sc.nextLine(), sc.nextLine().split(", "));

        System.out.println(result);
    }

    public static String solution(String video_len, String pos,
                           String op_start, String op_end, String[] commands) {
        int totalTime = calculator2(video_len);
        int curTime = calculator2(pos);
        int opStart = calculator2(op_start);
        int opEnd = calculator2(op_end);

        if (curTime >= opStart && curTime <= opEnd) {
            curTime = opEnd;
        }

        for (String command : commands) {

            if (command.equals("prev")) {
                curTime = prev(curTime);

            } else if (command.equals("next")) {
                curTime = next(curTime, totalTime);

            } else {
                return "잘못된 명령";
            }

            if (curTime >= opStart && curTime <= opEnd) {
                curTime = opEnd;
            }
        }

        return getTimeForm(curTime);
    }

    public static int prev(int curTime) {
        return Math.max(curTime - 10, 0);
    }

    public static int next(int curTime, int totalTime) {
        return Math.min(curTime + 10, totalTime);
    }

    public static String getTimeForm(int time) {
        int minute = time / 60;
        int second = time % 60;

        StringBuilder sb = new StringBuilder();

        if (minute < 10) {
            sb.append(0);
            sb.append(minute);
        } else {
            sb.append(minute);
        }

        sb.append(":");

        if (second < 10) {
            sb.append(0);
            sb.append(second);
        } else {
            sb.append(second);
        }

        return sb.toString();
    }

    public static int[] calculator(String time) {
        int[] result = new int[2];
        result[0] = Integer.parseInt(time.split(":")[0]);
        result[1] = Integer.parseInt(time.split(":")[1]);

        return result;
    }

    public static int calculator2(String time) {
        int result = 0;

        result += Integer.parseInt(time.split(":")[0]) * 60;
        result += Integer.parseInt(time.split(":")[1]);

        return result;
    }
}
