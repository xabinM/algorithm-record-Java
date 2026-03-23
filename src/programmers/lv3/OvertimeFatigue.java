package programmers.lv3;

import java.util.Collections;
import java.util.PriorityQueue;

public class OvertimeFatigue {

    public long solution(int n, int[] works) {

        int time = n;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.add(work);
        }

        while (time > 0) {
            int max = pq.poll();

            if (max == 0) {
                break;
            }

            pq.add(max - 1);

            time -= 1;
        }

        long result = 0;

        for (int w : pq) {
            result += (long) w * w;
        }

        return result;
    }
}
