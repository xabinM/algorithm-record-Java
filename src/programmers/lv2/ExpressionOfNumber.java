package programmers.lv2;

public class ExpressionOfNumber {

    public static void main(String[] args) {

    }

    public static int solution(int n) {

        int cnt = 0;

        int left = 1;
        int right = 1;
        int sum = 1;

        while (left <= n) {
            if (sum == n) {
                cnt++;
                sum -= left;
                left++;
            } else if (sum < n) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }

        return cnt;
    }
}
