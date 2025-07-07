package baekjoon.queue;

import java.util.*;

public class ClassroomAllocation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Lecture[] lectures = new Lecture[N];
        for (int i = 0; i < N; i++) {
            lectures[i] = new Lecture(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(lectures);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(lectures[0].end);

        for (int i = 1; i < N; i++) {
            if (lectures[i].start >= queue.peek()) {
                queue.poll();
            }
            queue.add(lectures[i].end);
        }

        System.out.println(queue.size());
    }

    private static class Lecture implements Comparable<Lecture> {
        int start, end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture object) {
            return this.start - object.start;
        }
    }
}
