package SSAFY.MST.unionFind;

import java.util.*;

public class Union {
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            sc.nextLine();

            int[] inputX = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] inputY = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            double E = Double.parseDouble(sc.next());

            List<Edge> edges = getEdges(inputX, inputY);

            int cnt = 0;
            long total = 0;
            makeSet();
            for (Edge edge : edges) {
                if (findSet(edge.u) != findSet(edge.v)) {
                    union(edge.u, edge.v);
                    total += edge.cost;
                    cnt++;
                    if (cnt == N - 1) {
                        break;
                    }
                }
            }
            long result = Math.round(total * E);
            System.out.println("#" + t + " " + result);
        }
    }

    private static List<Edge> getEdges(int[] inputX, int[] inputY) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                // i번째 섬 <-> j 번째 섬을 연결하는 간선정보
                int ix = inputX[i];
                int jx = inputX[j];
                int iy = inputY[i];
                int jy = inputY[j];
                long radius = (long) (ix - jx) * (ix - jx) + (long) (iy - jy) * (iy - jy);
                Edge edge = new Edge(i, j, radius);
                edges.add(edge);
            }
        }

        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Long.compare(o1.cost, o2.cost);
            }
        });
        return edges;
    }

    static class Edge {
        int u;      // 시작
        int v;      // 끝
        long cost;  // 비용

        public Edge(int u, int v, long cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }

    private static int[] parent;

    private static void makeSet() {
        parent = new int[N];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    private static int findSet(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = findSet(parent[x]);
    }

    private static void union(int x, int y) {
        int root1 = findSet(x);
        int root2 = findSet(y);

        parent[root2] =root1;
    }
}
