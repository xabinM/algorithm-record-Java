package programmers.lv1;


public class MemoryScore {

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] result = new int[photo.length];

        for (int i = 0; i < result.length; i++) {
            String[] arr = photo[i];
            int score = 0;
            for (String s : arr) {
                for (int j = 0; j < name.length; j++) {

                    if (name[j].equals(s)) {
                        score += yearning[j];
                        break;
                    }

                }
            }
            result[i] = score;
        }

        return result;
    }
}
