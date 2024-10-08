import java.util.Scanner;

public class baek16493 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 남은 기간
        int M = scanner.nextInt(); // 챕터 수
        int[][] chapters = new int[M][2];

        for (int i = 0; i < M; i++){
            chapters[i][0] = scanner.nextInt();
            chapters[i][1] = scanner.nextInt();
        }

        int[] dp = new int[N + 1];

        for (int i = 0; i < M; i++){
            for (int j = N; j > chapters[i][0] - 1; j--){
                dp[j] = Math.max(dp[j], dp[j - chapters[i][0]] + chapters[i][1]);
            }
        }

        System.out.println(dp[N]);
    }
}