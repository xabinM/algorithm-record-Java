package programmers.lv2;

import java.util.*;

public class ServerIncreaseCount {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] players = Arrays.stream(sc.nextLine().split(", ")).
                mapToInt(Integer::parseInt).toArray();

        int m = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(solution(players, m, k));
    }

    public static int solution(int[] players, int m, int k) {

        Queue<Integer> servers = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < 24; i++) {
            int needServer = players[i] / m;

            while (!servers.isEmpty() && servers.peek() <= i) {
                servers.poll();
            }

            if (needServer > servers.size()) {
                int increaseServer = needServer - servers.size();

                for (int j = 0; j < increaseServer; j++) {
                    servers.offer(i + k);
                    count++;
                }
            }
        }

        return count;
    }
}

