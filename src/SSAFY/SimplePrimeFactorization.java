import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimplePrimeFactorization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();

            Map<Integer, Integer> result = new HashMap<>();
            int[] keys = {2, 3, 5, 7, 11};

            for (int key : keys){
                result.put(key, 0);
            }

            int cur = N;
            while (true){
                if (cur == 1 || cur == 0) {
                    break;
                }

                for (int key : keys) {
                    if (cur % key == 0) {
                        result.put(key, result.get(key) + 1);
                        cur /= key;
                        break;
                    }
                }

                if (cur == N) {
                    break;
                }
            }

            System.out.println("#" + (i + 1) + " " + result.values().toString()
                    .replaceAll("[\\[\\]\\,]", ""));
        }
    }
}