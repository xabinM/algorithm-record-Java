package programmers.kakao;

public class YellowBlinker {

    public int solution(int[][] signals) {

        int G1 = signals[0][0];
        int Y1 = signals[0][1];
        int R1 = signals[0][2];

        int C1 = G1 + Y1 + R1;

        for (int k = 0; k < 100000; k++) {

            for (int o = 0; o < Y1; o++) {

                int t = G1 + o + k * C1;

                boolean ok = true;

                for (int i = 1; i < signals.length; i++) {

                    int G =  signals[i][0];
                    int Y =  signals[i][1];
                    int R = signals[i][2];

                    int C = G + Y + R;

                    int pos = t % C;

                    if (pos < G || pos >= G + Y) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    return t + 1;
                }
            }
        }
        return -1;
    }
}
