package baekjoon.graphSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ShortestPath1753 {
    private static final int INF = Integer.MAX_VALUE;
    private static List<Node>[] graph;
    private static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();   // 정점의 개수
        int E = sc.nextInt();   // 간선의 개수
        int K = sc.nextInt();   // 시작 정점 번호


        graph = new ArrayList[V + 1];
        dist = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Node(v, w));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.index;
            int nowCost = current.cost;

            if (dist[now] < nowCost) continue;

            for (Node next : graph[now]) {
                int cost = dist[now] + next.cost;
                if (cost < dist[next.index]) {
                    dist[next.index] = cost;
                    pq.offer(new Node(next.index, cost));
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int index, cost;

        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }
}
