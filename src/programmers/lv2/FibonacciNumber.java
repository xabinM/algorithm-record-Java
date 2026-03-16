package programmers.lv2;

public class FibonacciNumber {

    public static void main(String[] args) {

        System.out.println(solution(6));
    }

    public static int solution(int n) {

        return fibonacci(n) % 1234567;
    }

    private static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
