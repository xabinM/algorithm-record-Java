package baekjoon.backTrack;

import java.util.*;

public class ABCDE13023 {
    private static int N;
    private static int M;
    private static List<int[]> relationship;
    private static boolean[] visited;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        relationship = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            relationship.add(Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        visited = new boolean[M];

        // 친구 연결 체인이 있어야함 인덱스가 사람이고 밸류가 연결된 친구, 근데 친구가 여러명일 수 있음. 자료 구조를 뭘써야할지 정해야댐
    }


}
