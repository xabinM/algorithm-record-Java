import java.util.Scanner;

public class baek10819 {
    static int[] arr;
    static boolean[] visited;
    static int maxValue = 0;

    public static void backTrack(int[] temp, int depth, int N){
        if (depth == N){
            int currentMaxValue = 0;
            for (int i = 0; i < N - 1; i++){
                currentMaxValue += Math.abs(temp[i] - temp[i + 1]);
            }
            maxValue = Math.max(maxValue, currentMaxValue);
            return;
        }

        for (int i = 0; i < N; i++){
            if (!visited[i]){
                visited[i] = true;
                temp[depth] = arr[i];
                backTrack(temp, depth + 1, N);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        visited = new boolean[N];
        arr = new int[N];

        for (int i = 0; i < N; i++){
            arr[i] = scanner.nextInt();
        }

        int[] temp = new int[N];

        backTrack(temp, 0, N);

        System.out.println(maxValue);
        scanner.close();;
    }
}
