package programmers.lv3;

public class Network {

    public static int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];

        int result = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, computers);
                result++;
            }
        }

        return result;
    }

    private static void dfs(int node,  boolean[] visited, int[][] computers) {
        visited[node] = true;

        for (int i = 0; i < computers.length; i++) {

            if (computers[node][i] == 1 && !visited[i]) {
                dfs(i,  visited, computers);
            }
        }
    }
}
