package baekjoon.graphSearch;

import java.io.*;
import java.util.*;

public class Hacking1325 {
    static int n, m;
    static List<Integer>[] graph;
    static int[] hackedCounts;

    public static void main(String[] args) throws IOException {
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        // 역방향 간선 저장 (B가 A를 신뢰 => B → A)
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        hackedCounts = new int[n + 1];

        // 각 정점에서 BFS 수행
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true;

            int count = 0;

            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int next : graph[current]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                        count++;
                    }
                }
            }

            hackedCounts[i] = count;
        }

        // 가장 많은 컴퓨터를 해킹할 수 있는 경우 찾기
        int max = Arrays.stream(hackedCounts).max().getAsInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (hackedCounts[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }
}


