package programmers.lv2;

import java.util.Arrays;

public class MakeMinimum {

    public static void main(String[] args) {


    }

    public static int solution(int []A, int []B) {

        Arrays.sort(A);
        Arrays.sort(B);

        int n = A.length;

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += A[i] * B[n - 1 - i];
        }

        return result;
    }
}
