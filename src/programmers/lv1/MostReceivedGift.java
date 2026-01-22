package programmers.lv1;

import java.util.*;

public class MostReceivedGift {

    public static void main(String[] args) {

        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi",
                "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

//        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
//        String[] gifts = {"alessandro brad", "alessandro joy",
//                "alessandro conan", "david alessandro", "alessandro david"};

        System.out.println(solution(friends, gifts));
    }

    public static int solution(String[] friends, String[] gifts) {
        List<Man> mans = new ArrayList<>();
        for (String name : friends) {
            mans.add(new Man(name));
        }

        for (String gift : gifts) {
            String give = gift.split(" ")[0];
            String take = gift.split(" ")[1];

            Man gMan = findMan(mans, give);
            Man tMan = findMan(mans, take);

            gMan.give++;
            tMan.take++;

            if (gMan.friends.containsKey(take)) {
                gMan.friends.put(take, 1);
            } else {
                gMan.friends.put(take, gMan.friends.get(take) + 1);
            }
        }

        for (Man man : mans) {
            man.score = man.give - man.take;
        }

        // 다음달 선물 개수 찾기
        for (Man man : mans) {


        }

        return 0;
    }

    private static Man findMan(List<Man> mans, String name) {
        for (Man man : mans) {
            if (man.name.equals(name)) {
                return man;
            }
        }

        return null;
    }

    private static class Man {
        String name;

        Map<String, Integer> friends = new HashMap<>();

        //선물지수
        int give;
        int take;
        int score;

        int next;

        public Man(String name) {
            this.name = name;
        }
    }
}
