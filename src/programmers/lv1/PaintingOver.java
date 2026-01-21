package programmers.lv1;

import java.util.Arrays;
import java.util.Scanner;

public class PaintingOver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int[] section = Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(solution(n, m, section));
    }

    public static int solution(int n, int m, int[] section) {
        int answer = 0;
        int right = 0;

        for (int sec : section) {
            int cur = sec - 1;

            if (right <= cur) {
                right = cur + m;
                answer++;
            }
        }

        return answer;
    }
}
