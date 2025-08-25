package SSAFY.삼성A형;

import java.util.*;

public class practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {

            int N = sc.nextInt();
            int K = sc.nextInt();
            sc.nextLine();

            String[] temp = sc.nextLine().split("");
            LinkedList<String> arr = new LinkedList<>(Arrays.asList(temp));

            Set<String> hexes = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N / 4; i++) {   // 자리 변경 후 카운트

                for (String s : arr) {
                    sb.append(s);
                    if (sb.length() == N / 4) {
                        hexes.add(String.valueOf(sb));
                        sb = new StringBuilder();
                    }
                }
                arr.addLast(arr.pollFirst());
            }

            List<Integer> password = new ArrayList<>();
            for (String hex : hexes) {
                int integer = Integer.parseInt(hex, 16);
                password.add(integer);
            }

            password.sort(null);

            System.out.println("#" + t + " " + password.get(password.size() - K));
        }
    }
}
