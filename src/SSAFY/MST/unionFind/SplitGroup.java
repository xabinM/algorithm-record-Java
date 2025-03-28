package SSAFY.MST.unionFind;

import java.util.*;

public class SplitGroup {
    private static int N, M;
    private static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {

            N = sc.nextInt();
            M = sc.nextInt();

            List<Node> nodes = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                nodes.add(new Node(u, v));
            }

            initialSet();
            for (Node node : nodes) {
                union(node.u, node.v);
            }

            Set<Integer> result = new HashSet<>();
            for (int i = 1; i < N + 1; i++) {
                result.add(findSet(parent[i]));
            }

            System.out.println("#" + t + " " + result.size());
        }
    }

    static class Node {
        int u;
        int v;

        public Node(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    private static void initialSet() {
        parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }
    }

    private static int findSet(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = findSet(parent[x]);
    }

    private static void union(int u, int v) {
        int root1 = findSet(u);
        int root2 = findSet(v);

        parent[root2] = root1;
    }
}
