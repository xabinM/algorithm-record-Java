import java.util.Scanner;

public class baek1535 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] hp = new int[N];
        int[] happy = new int[N];

        for (int i = 0; i < N; i++){
            hp[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++){
            happy[i] = scanner.nextInt();
        }

        int[] dp = new int[101];

        for (int i = 0; i < N; i++){
            for (int j = 100; j > hp[i] - 1; j--){
                dp[j] = Math.max(dp[j], dp[j - hp[i]] + happy[i]);
            }
        }

        System.out.println(dp[99]);
    }
}