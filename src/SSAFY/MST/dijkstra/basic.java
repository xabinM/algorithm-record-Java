package SSAFY.MST.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class basic {
    private static final int INF = Integer.MAX_VALUE;
    private static int V, E;
    private static List<Edge>[] adj;
    private static int[] dist;

    static String input = "6 11\r\n"
            + "0 1 4\r\n"
            + "0 2 2\r\n"
            + "0 5 25\r\n"
            + "1 3 8\r\n"
            + "1 4 7\r\n"
            + "2 1 1\r\n"
            + "2 4 4\r\n"
            + "3 0 3\r\n"
            + "3 5 6\r\n"
            + "4 3 5\r\n"
            + "4 5 12\r\n"
            + "";


    public static void main(String[] args) {
        Scanner sc = new Scanner(input);

        V = sc.nextInt();
        E = sc.nextInt();
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        dist = new int[V];
        Arrays.fill(dist, INF);

        for(int i = 0 ; i < E; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int cost = sc.nextInt();

            adj[s].add(new Edge(e, cost)); //유향
        }


        System.out.println(Arrays.toString(adj));
        System.out.println(Arrays.toString(dist));
        System.out.println("---------------------------");

        dijkstra(0);
    }

    static class Edge {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "(" + to + ", " + cost + ")";
        }
    }

    private static void dijkstra(int start) {
        boolean[] visited = new boolean[V];

        dist[start] = 0;
        for (int i = 0; i < V - 1; i ++) {
            int min = INF;
            int idx = -1;
            for (int j = 0; j < V; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    idx = j;
                }
            }

            if (idx == -1){
                System.out.println("break!");
                break;
            }

            visited[idx] = true;
            System.out.println(Arrays.toString(visited));
            System.out.println("------------");

            for (Edge e : adj[idx]) {
                if (!visited[e.to] && dist[e.to] > dist[idx] + e.cost) {
                    dist[e.to] = dist[idx] + e.cost;
                }
            }

            System.out.println(Arrays.toString(adj));
            System.out.println(Arrays.toString(dist));
            System.out.println("----------------------------");

        }
    }
}
