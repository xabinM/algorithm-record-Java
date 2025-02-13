import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = 10;

        for(int tc = 1; tc <= T; tc++) {

            //덤프 횟수와 각 상자의 높이가 주어짐
            //입력된 덤프 횟수까지 돌면서 가장 높은 상자에서 --, 가장 낮은 상자에서 ++
            //덤프 횟수가 채워지거나, 가장 높은 상자와 가장 낮은 상자의 높이가 같아지면 종료

            //dump 횟수 입력 받기
            int dump = sc.nextInt();
            //상자 높이 배열
            int[] height = new int[100];
            //상자 높이 배열 입력 받기
            for(int i = 0; i < 100; i++) {
                height[i] = sc.nextInt();
            }

            //정렬했으므로, 높은 상자는 마지막 인덱스, 높은 상자는 첫 인덱스
            //가장 높은 상자에서 --로 하나를 빼서, 가장 낮은 상자에 ++로 넣는 과정을 반복
            //근데 이때, 가장 높은 상자의 인덱스가 자꾸 바뀔 수 있는 거 아닌가
            //그러면 정렬을 안에서 해줘야 하나
            //진짜 거짓말... 왜 6번만 안 돌아 바보
            int mx = 0;
            int mn = 0;
            for(int i = 0; i < dump; i++) {
                //정렬하기
                Arrays.sort(height);
                if(height[99] > height[0]) {
                    height[99]--;
                    height[0]++;
                    Arrays.sort(height);
                    mn = height[0];
                    mx = height[99];
                }
            }
            System.out.println("#"+tc+" "+(mx-mn));
        }
    }
}

