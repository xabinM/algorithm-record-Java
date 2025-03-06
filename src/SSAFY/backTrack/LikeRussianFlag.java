package SSAFY.backTrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LikeRussianFlag {
    static int N;
    static char[] chars = {'W', 'B', 'R'};
    static List<char[]> strCombination;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            int M = sc.nextInt();
            sc.nextLine();


            char[][] graph = new char[N][M];
            for (int i = 0; i < N; i++) {
                graph[i] = sc.nextLine().toCharArray();
            }

            // 둘 째줄 부터 가능한 색깔 조합을 구한다.
            strCombination = new ArrayList<>();
            backTrack(new StringBuilder(), 0, false, false);

            int result = getResult(graph);

            System.out.println("#" + t + " " + result);
        }
    }

    private static int getResult(char[][] graph) {
        int result = 0;

        // 첫째 줄 흰색이 아닌 것 카운트
        for (char color : graph[0]) {
            if (color != 'W') {
                result += 1;
            }
        }

        // 듈 째줄부터 구한 색깔 조합으로 최소 색칠 횟수 찾기
        int minCnt = Integer.MAX_VALUE;
        for (char[] strCom : strCombination) {
            int sumChangeCnt = 0;

            for (int i = 1; i < N; i++) {
                char color = strCom[i - 1];

                for (char target : graph[i]) {
                    if (color != target){
                        sumChangeCnt += 1;
                    }
                }
            }
            minCnt = Math.min(minCnt, sumChangeCnt);
        }
        result += minCnt;

        return result;
    }

    // 백 트래킹, 둘 째줄부터 가능한 색깔 순서 조합 구하기
    private static void backTrack(StringBuilder temp, int idx, boolean hasB, boolean hasR) {
        if (temp.length() == N - 1) {
            if (hasB && hasR){
                strCombination.add(temp.toString().toCharArray());
            }
            return;
        }
        
        for (int i = idx; i < 3; i++) {
            temp.append(chars[i]);
            backTrack(temp, i, hasB || (chars[i] == 'B'), hasR || (chars[i] == 'R'));
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
