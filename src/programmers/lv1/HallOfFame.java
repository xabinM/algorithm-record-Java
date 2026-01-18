package programmers.lv1;

import java.util.*;

public class HallOfFame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        sc.nextLine();
        int[] score = Arrays.stream(sc.nextLine().split(", "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        System.out.println(Arrays.toString(solution(k, score)));
    }

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        LinkedList<Integer> hall = new LinkedList<>();

        for (int i = 0; i < score.length; i++) {

            hall.add(score[i]);

            hall.sort(Comparator.naturalOrder());

            if (hall.size() > k) {
                hall.removeFirst();
            }

            answer[i] = hall.getFirst();
        }

        return answer;
    }
}
