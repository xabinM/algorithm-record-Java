package SSAFY.삼성A형;

import java.util.*;
import java.util.stream.Collectors;

public class TreasureBoxPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T ; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            sc.nextLine();

            LinkedList<String> input = Arrays.stream(sc.nextLine().split("")).
                    collect(Collectors.toCollection(LinkedList::new));

            Set<String> hexs = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N / 4; i++){
                for (int j = 0; j < input.size(); j++) {
                    sb.append(input.get(j));
                    if (sb.length() == N / 4) {
                        hexs.add(sb.toString());
                        sb = new StringBuilder();
                    }
                }
                input.addLast(input.pollFirst());
            }

            List<Integer> passwords = new ArrayList<>();
            for (String hex : hexs) {
                int decimal = Integer.parseInt(hex, 16);
                passwords.add(decimal);
            }

            passwords.sort(null);

            System.out.println("#" + t + " " + passwords.get(passwords.size() - K));
        }
    }
}
