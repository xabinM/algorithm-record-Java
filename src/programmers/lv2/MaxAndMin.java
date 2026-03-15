package programmers.lv2;

public class MaxAndMin {

    public static void main(String[] args) {

        String s = "-1 -2 -3 -4";

        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String[] splitS = s.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String cur : splitS) {
            int iCur =  Integer.parseInt(cur);

            max = Math.max(iCur, max);
            min = Math.min(iCur, min);
        }

        return min +
                " " +
                max;
    }
}
