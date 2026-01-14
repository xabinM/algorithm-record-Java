package programmers.lv1;

public class Park {

    public static int solution(int[] mats, String[][] park) {

        int answer = -1;

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length; j++) {
                if (!park[i][j].equals("-1")) {
                    continue;
                }

                for (int mat : mats) {
                    if (search(park, i, j, mat)) {
                        answer = Math.max(answer, mat);
                    }
                }
            }
        }

        return answer;
    }

    private static boolean search(String[][] park, int x, int y, int mat) {
        for (int i = 0; i < mat; i++) {
            for (int j = 0; j < mat; j++) {
                if (x + mat > park.length || y + mat > park[0].length) {
                    return false;
                }

                if (!park[x + i][y + j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}
