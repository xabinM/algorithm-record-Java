package programmers.lv2;

public class RepeatBinaryTransformation {

    public static void main(String[] args) {

    }

    public static int[] solution(String s) {

        int transformCount = 0;
        int zeroCount = 0;

        while (!s.equals("1")) {

            int originalLength = s.length();

            s = s.replace("0", "");

            zeroCount += originalLength - s.length();

            s = Integer.toBinaryString(s.length());

            transformCount++;
        }

        return new int[]{transformCount, zeroCount};
    }
}
