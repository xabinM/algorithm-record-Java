package SSAFY.미정;

import java.util.*;
import java.util.stream.Collectors;

public class MaximumPrize {
    private static int repeat;
    private static int maxValue;
    private static Set<String> visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int t = 1; t <= T; t++) {
            String[] input = sc.nextLine().split(" ");

            List<String> origin = Arrays.stream(input[0].split("")).
                    collect(Collectors.toCollection(LinkedList::new));
            repeat = Integer.parseInt(input[1]);

            visited = new HashSet<>();
            maxValue = Integer.MIN_VALUE;

            backTrack(origin, 0, 0);

            System.out.println("#" + t + " " + maxValue);
        }
    }

    private static void backTrack(List<String> temp, int idx, int depth) {
        if (depth == repeat) {
            maxValue = Math.max(maxValue, translate(temp));
            return;
        }

        // 중복 체크
        String state = String.join("", temp) + "-" + depth;
        if (visited.contains(state)) {
            return;
        }
        visited.add(state);

        for (int i = idx; i < temp.size() - 1; i++) {
            for (int j = i + 1; j < temp.size(); j++) {
                // 리스트 요소 교환
                changeValue(temp, i, j);
                backTrack(temp, i, depth + 1);
                // 교환 했던 요소 되돌리기
                changeValue(temp, j, i);
            }
        }
    }

    private static void changeValue(List<String> list, int idx1, int idx2) {
        String temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    private static int translate(List<String> temp) {
        StringBuilder sb = new StringBuilder();

        for (String str : temp) {
            sb.append(str);
        }

        return Integer.parseInt(sb.toString());
    }
}
