package SSAFY.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardGame {
    private static List<Integer> gyuyoung;
    private static List<Integer> inyoung;
    private static boolean[] visited;
    private static int win;
    private static int lose;
    private static int[] temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int t = 1; t <= T; t++) {
            gyuyoung = Arrays.stream(sc.nextLine().split(" ")).
                    map(Integer::parseInt).
                    collect(Collectors.toList());

            inyoung = getNumbers(gyuyoung);

            visited = new boolean[9];
            win = 0;
            lose = 0;
            temp = new int[9];
        }
    }

    private static void backTrack(int depth) {

        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                temp[depth] = i;
                visited[i] = true;
                if (gyuyoung.get(i) > inyoung.get()) {

                }

            }

        }
    }

    private static List<Integer> getNumbers(List<Integer> numbers) {
        List<Integer> another = new ArrayList<>();
        for (int i = 1; i <= 18; i++) {
            if (!numbers.contains(i)) {
                another.add(i);
            }
        }
        return another;
    }

}
1   2  3  4  5  6  7  8  9
10 11 12 13 14 15 16 17 18