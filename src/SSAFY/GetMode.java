package SSAFY;

import java.util.*;

public class GetMode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            int t = sc.nextInt();
            sc.nextLine();

            String[] tempNums = sc.nextLine().split(" ");
            Map<Integer, Integer> modeCount = new HashMap<>();
            for (String num : tempNums) {
                int curKey = Integer.parseInt(num);
                if (!modeCount.containsKey(curKey)) {
                    modeCount.put(curKey, 1);
                } else {
                    modeCount.put(curKey, modeCount.get(curKey) + 1);
                }
            }
            int mode = Integer.MIN_VALUE;
            int maxKey = Integer.MIN_VALUE;

            for (Integer key : modeCount.keySet()) {
                if (modeCount.get(key) >= mode) {
                    mode = modeCount.get(key);
                    if (key > maxKey) {
                        maxKey = key;
                    }
                }
            }
            System.out.println("#" + t + " " + maxKey);
        }
    }
}
