package programmers.lv1;

import java.util.Arrays;

public class ParkWork {

    public static void main(String[] args) {

        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};

        System.out.println(Arrays.toString(solution(park, routes)));
    }

    public static int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();

        String[][] arr = new String[h][w];
        for (int i = 0; i < h; i++) {
            arr[i] = park[i].split("");
        }

        int startX = 0, startY = 0;

        // 시작 위치 찾기
        S:
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (arr[i][j].equals("S")) {
                    startX = i;
                    startY = j;
                    break S;
                }
            }
        }

        for (String s : routes) {
            String way = s.split(" ")[0];
            int dis = Integer.parseInt(s.split(" ")[1]);

            int nx = startX;
            int ny = startY;
            boolean canMove = true;

            for (int i = 0; i < dis; i++) {
                switch (way) {
                    case "E" -> ny++;
                    case "W" -> ny--;
                    case "S" -> nx++;
                    case "N" -> nx--;
                }

                // 범위 체크
                if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                    canMove = false;
                    break;
                }

                // 장애물 체크
                if (arr[nx][ny].equals("X")) {
                    canMove = false;
                    break;
                }
            }

            if (canMove) {
                startX = nx;
                startY = ny;
            }
        }

        return new int[]{startX, startY};
    }
}
