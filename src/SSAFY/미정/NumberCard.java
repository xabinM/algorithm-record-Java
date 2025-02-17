package SSAFY.미정;

import java.util.*;

public class NumberCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            sc.nextLine();

            Map<Integer, Integer> cardCount = new HashMap<>();
            List<Integer> temp = new ArrayList<>();

            String[] tempStr = sc.nextLine().split("");

            for (int j = 0; j < N; j++) {
                temp.add(Integer.parseInt(tempStr[j]));
            }

            for (int curKey : temp) {
                if (!cardCount.containsKey(curKey)) {
                    cardCount.put(curKey, 1);
                } else {
                    cardCount.put(curKey, cardCount.get(curKey) + 1);
                }
            }
            int modeCard = Integer.MIN_VALUE;
            int maxKey = Integer.MIN_VALUE;

            for (Integer key : cardCount.keySet()) {
                if (cardCount.get(key) >= modeCard) {
                    modeCard = cardCount.get(key);
                    if (key > maxKey) {
                        maxKey = key;
                    }
                }
            }
            System.out.println("#" + (i + 1) + " " + maxKey + " " + modeCard);
        }
    }
}
