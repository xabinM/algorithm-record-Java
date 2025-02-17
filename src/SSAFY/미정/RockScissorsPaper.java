package SSAFY.미정;

import java.util.Scanner;

public class RockScissorsPaper {
    public static void main(String[] args) {
        System.out.println("가위바위보 게임을 시작합니다. 아래 보기중 하나를 고르세요.\n");

        System.out.println("5판 3승");
        System.out.println("3판 2승");
        System.out.println("1판 1승\n");

        System.out.print("번호를 입력하세요.");
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        int choiceResult = choiceMenu(input);
        int gameCount = 0;

        int userWinCount = 0;
        int ComputerWinCount = 0;

        while (gameCount < choiceResult && userWinCount < (choiceResult + 1) / 2 && ComputerWinCount < (choiceResult + 1) / 2) {
            System.out.print("가위바위보 중 하나 입력: ");
            String rspInput = sc.nextLine();

            int userRSP = translateRSP(rspInput);
            int computerRSP = (int) (Math.random() * 3) + 1;

            int sumForResult = userRSP + computerRSP;

            if (userRSP == computerRSP) {
                gameCount += 1;
                System.out.println("비겼습니다!!!");
            } else if (sumForResult == 3) {
                if (userRSP > computerRSP) {
                    userWinCount += 1;
                    System.out.println("이겼습니다!!!");
                } else {
                    ComputerWinCount += 1;
                    System.out.println("졌습니다!!!");
                }
                gameCount += 1;
            } else if (sumForResult == 5) {
                if (userRSP > computerRSP) {
                    userWinCount += 1;
                    System.out.println("이겼습니다!!!");
                } else {
                    ComputerWinCount += 1;
                    System.out.println("졌습니다!!!");
                }
                gameCount += 1;
            } else if (sumForResult == 4) {
                if (userRSP > computerRSP) {
                    ComputerWinCount += 1;
                    System.out.println("졌습니다!!!");
                } else if (userRSP < computerRSP) {
                    userWinCount += 1;
                    System.out.println("이겼습니다!!!");
                }
                gameCount += 1;
            }
        }

        determineWinner(userWinCount, ComputerWinCount);
    }

    private static int choiceMenu(String input) {
        return switch (input) {
            case "1" -> 5;
            case "2" -> 3;
            case "3" -> 1;
            default -> 0;
        };
    }

    private static int translateRSP(String input) {
        return switch (input) {
            case "가위" -> 1;
            case "주먹" -> 2;
            case "보" -> 3;
            default -> 0;
        };
    }

    private static void determineWinner(int userWinCount, int computerCount) {
        if (userWinCount > computerCount) {
            System.out.println("###사용자 승!!!");
        } else if (userWinCount < computerCount){
            System.out.println("###컴퓨터 승!!!");
        } else {
            System.out.println("###비김!!!");
        }
    }
}
