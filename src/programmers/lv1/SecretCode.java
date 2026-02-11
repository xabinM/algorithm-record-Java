package programmers.lv1;

public class SecretCode {

    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

        System.out.println(solution(s, skip, index));
    }

    public static String solution(String s, String skip, int index) {
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        String[] splitS = s.split("");
        String[] splitSkip = skip.split("");
        int curI = 0;

        for (int i = 0; i < splitS.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (alphabet[j].equals(splitS[i])) {
                    curI = j;
                    break;
                }
            }

            int tempIndex = index;
            int temp = curI;
            while (true) {
                if (tempIndex == 0) {
                    splitS[i] = alphabet[temp];
                    break;
                }

                if (temp < 25){
                    temp++;
                } else {
                    temp = 0;
                }

                boolean isSkip = false;

                for (String curSkip : splitSkip) {
                    if (alphabet[temp].equals(curSkip)) {
                        isSkip = true;
                        break;
                    }
                }

                if (!isSkip) {
                    tempIndex--;
                }
            }

            curI = 0;
        }

        StringBuilder sb = new StringBuilder();
        for (String ss : splitS) {
            sb.append(ss);
        }

        return String.valueOf(sb);
    }
}
