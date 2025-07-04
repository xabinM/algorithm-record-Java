package baekjoon.queue;

import java.io.*;
import java.util.*;

public class RailWay {
    static class Person {
        int start, end;
        Person(int a, int b) {
            this.start = Math.min(a, b);
            this.end = Math.max(a, b);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            people.add(new Person(a, b));
        }

        int D = Integer.parseInt(br.readLine());

        people.sort((p1, p2) -> Integer.compare(p1.end, p2.end));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = 0;

        for (Person p : people) {
            int startLimit = p.end - D;

            if (p.start >= startLimit) {
                pq.offer(p.start);
            }

            while (!pq.isEmpty() && pq.peek() < startLimit) {
                pq.poll();
            }

            max = Math.max(max, pq.size());
        }

        System.out.println(max);
    }
}
