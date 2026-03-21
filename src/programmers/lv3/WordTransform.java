package programmers.lv3;

import java.util.LinkedList;
import java.util.Queue;

public class WordTransform {

    public static void main(String[] args) {


    }

    public int solution(String begin, String target, String[] words) {

        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.offer(begin);
        int depth = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                if (cur.equals(target)) {
                    return depth;
                }

                for (int j = 0; j < words.length; j++) {

                    if (!visited[j] && canChange(words[j], cur)) {
                        queue.offer(words[j]);
                        visited[j] = true;
                    }
                }
            }

            depth++;
        }

        return 0;
    }

    private static boolean canChange(String a, String b) {

        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;
    }
}
