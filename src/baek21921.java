import java.util.ArrayList;
import java.util.Scanner;

public class baek21921 {
    public static void solution(int N, int X, int[] visitor){
        ArrayList<Integer> visitorForX = new ArrayList<>();

        // 시작 윈도우 값 저장
        int initialSum = 0;
        for (int i = 0; i < X; i++){
            initialSum += visitor[i];
        }
        visitorForX.add(initialSum);

        // 슬라이딩 윈도우 값 ArrayList에저장
        for (int i = 0; i < N - X; i++){
            int newSum = visitorForX.get(i) - visitor[i] + visitor[i + X];
            visitorForX.add(newSum);
        }

        // 최대값 찾기
        int maxVisitors = 0;
        for (int sum : visitorForX){
            if (sum > maxVisitors){
                maxVisitors = sum;
            }
        }

        // 결과 출력
        if (maxVisitors == 0){
            System.out.println("SAD");
        } else{
            int count = 0;
            for (int sum : visitorForX){
                if (sum == maxVisitors){
                    count += 1;
                }
            }
            System.out.println(maxVisitors);
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 입력 스트림 시작
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        int[] visitor = new int[N];
        for (int i = 0; i < N; i++){
            visitor[i] = scanner.nextInt();
        }
        scanner.close(); // 입력 스트림 종료

        solution(N, X, visitor);
    }
}