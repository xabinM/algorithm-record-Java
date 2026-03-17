package programmers.lv2;

public class Carpet {

    public int[] solution(int brown, int yellow) {

        int total = brown + yellow;

        for (int height = 1; height <= total; height++) {
            if (total % height != 0) {
                continue;
            }

            int width = total / height;

            if (width < height) {
                continue;
            }

            if ((width - 2) * (height - 2) == yellow) {
                return new int[]{width, height};
            }
        }

        return new int[0];
    }
}
