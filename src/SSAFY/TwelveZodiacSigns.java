package SSAFY;

import java.util.List;
import java.util.Scanner;

public class TwelveZodiacSigns {
    public static void main(String[] args) throws IllegalAccessException {
        Scanner sc = new Scanner(System.in);
        String input;

        do {
            System.out.print("60갑자를 입력하세요: ");
            input = sc.nextLine();

            if (input.equals("종료")) {
                break;
            }

            try {
                int startYear = getStartYear(input);

                for (int resultYear = startYear; resultYear <= 2100; resultYear+=60) {
                    if (resultYear < 1800) {
                        continue;
                    }
                    System.out.print(resultYear + " ");
                }
                System.out.println();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private static int getStartYear(String input) {
        List<String> tenHeavenlyStems = List.of("갑", "을", "병", "정", "무", "기", "경", "신", "임", "계");
        List<String> twelveEarthlyBranches = List.of("자", "축", "인", "묘", "진", "사", "오", "미", "신", "유", "술", "해");

        int startYear = 0;

        int ten = -1;
        int twelve = -1;

        for (int i = 0; i < 10; i++) {
            if (input.contains(tenHeavenlyStems.get(i))) {
                ten = i;
                break;
            }
        }
        for (int i = 0; i < 12; i++) {
            if (input.contains(twelveEarthlyBranches.get(i))) {
                twelve = i;
                break;
            }
        }

        if (ten == -1 || twelve == -1) {
            throw new IllegalArgumentException("잘못된 입력");
        }

        if (ten < twelve) {
            twelve -= 12;
        }

        int n = ten - twelve;
        if (n == 0) {
            startYear = twelve;
        } else {
            startYear = 12 * (n/2) + twelve;
        }

        startYear += 1744;
        return startYear;
    }
}
