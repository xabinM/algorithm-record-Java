package baekjoon.backTrack;

import java.util.*;

public class ABCDE13023 {
    private static final List<List<Integer>> relationship = new ArrayList<>();
    private static boolean[] visited;
    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        result = 0;

        for (int i = 0; i < N; i++) {
            relationship.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            addRelationship(a, b);
        }

        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(0, i);
            visited[i] = false;
            if (result == 1) {
                break;
            }
        }
        System.out.println(result);
    }

    private static void dfs(int depth, int idx) {
        if (depth >= 4) {
            result = 1;
            return;
        }

        if (result == 1) {
            return;
        }

        List<Integer> cur = relationship.get(idx);
        for (Integer i : cur) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i);
                visited[i] = false;
            }
        }
    }

    private static void addRelationship(int a, int b) {
        relationship.get(a).add(b);
        relationship.get(b).add(a);
    }
}
