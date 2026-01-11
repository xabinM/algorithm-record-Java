package baekjoon.permutation_combination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChickenDelivery {
    static int N, M;
    static List<Node> chickenRestaurant;
    static List<Node> house;
    static List<Integer> chickenDistance;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        chickenRestaurant = new ArrayList<>();
        house = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cur = sc.nextInt();

                if (cur == 2) {
                    chickenRestaurant.add(new Node(i, j));
                } else if (cur == 1) {
                    house.add(new Node(i, j));
                }
            }
        }

        combination(0, 0, new int[M]);
        System.out.println(min);
    }

    private static void combination(int start, int depth, int[] arr) {
        if (depth == M) {
            min = Math.min(min, getChickenDistance(arr));
            return;
        }

        for (int i = start; i < chickenRestaurant.size(); i++) {
            arr[depth] = i;
            combination(i + 1, depth + 1, arr);
        }
    }

    private static void permutation(int depth, int[] arr, boolean[] visited) {
        if (depth == M) {
            min = Math.min(min, getChickenDistance(arr));
            return;
        }

        for (int i = 0; i < chickenRestaurant.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                permutation(depth + 1, arr, visited);
                visited[i] = false;
            }
        }
    }

    private static int getChickenDistance(int[] selected) {
        int total = 0;
        for (Node h : house) {
            int temp = Integer.MAX_VALUE;
            for (int i : selected) {
                temp = Math.min(temp, calculateDistance(h, chickenRestaurant.get(i)));
            }
            total += temp;
        }
        return total;
    }

    private static int calculateDistance(Node c, Node h) {
        return Math.abs(c.x - h.x) + Math.abs(c.y - h.y);
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
