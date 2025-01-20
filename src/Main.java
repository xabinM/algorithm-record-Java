import java.util.Scanner;

// 12904
public class Main {
    public static void main(String[] args) {
        System.out.println("월과 일을 입력하세요.");
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        int month = Integer.parseInt(input[0]);
        int day = Integer.parseInt(input[1]);

        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int allDays = day;

        for (int temp = month - 1;  temp > 0; temp--) {
            allDays += months[temp - 1];
        }

        System.out.println(month + "월 " + day + "일은 " + allDays + "번째 날입니다.");
    }
}