package SSAFY.미정;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trust {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();
        sc.nextLine();

        for (int t = 1; t <= TC; t++) {
            String[] input = sc.nextLine().split(" ");

            int N = Integer.parseInt(input[0]);

            List<Command> commands = new ArrayList<>();
            for (int i = 1; i < input.length; i += 2) {
                commands.add(new Command(input[i], Integer.parseInt(input[i + 1])));
            }

            int time = 0;
            int oTime = 0;
            int bTime = 0;
            int oPos = 1;
            int bPos = 1;

            // B 2 O 1 O 2 B 4
            for (Command command : commands) {
                if (command.robotName.equals("O")) {
                    oTime += Math.abs(command.position - oPos) + 1;   // +1은 버튼 누르는 시간
                    if (oTime > time) {
                        time = oTime;
                    } else {
                        time++;
                        oTime = time;
                    }
                    oPos = command.position;
                } else {
                    bTime += Math.abs(command.position - bPos) + 1;   // +1은 버튼 누르는 시간
                    if (bTime > time) {
                        time = bTime;
                    } else {
                        time++;
                        bTime = time;
                    }
                    bPos = command.position;
                }
            }
            System.out.println("#" + t + " " + time);
        }
    }
}

class Command {
    String robotName;
    int position;

    public Command(String robotName, int position) {
        this.robotName = robotName;
        this.position = position;
    }
}
