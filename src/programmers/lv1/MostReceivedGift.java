package programmers.lv1;

import java.util.*;

public class MostReceivedGift {

    public static void main(String[] args) {

//        String[] friends = {"muzi", "ryan", "frodo", "neo"};
//        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi",
//                "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts = {"alessandro brad", "alessandro joy",
                "alessandro conan", "david alessandro", "alessandro david"};

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

            gMan.record.put(tMan, gMan.record.getOrDefault(tMan, 0) + 1);
        }

        for (Man man : mans) {
            man.score = man.give - man.take;
        }

        // 다음달 선물 개수 찾기
        // 사람 둘을 정하고 서로 누구의 next가 증가할지 정해야함
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                Man me = mans.get(i);
                Man you = mans.get(j);

                countGift(me, you);
            }
        }

        int max = 0;
        for (Man man : mans) {
            max = Math.max(man.next, max);
        }

        return max;
    }

    private static void countGift(Man me, Man you) {
        int meToYouCount = me.record.getOrDefault(you, 0);
        int youTomeCount = you.record.getOrDefault(me, 0);

        if (meToYouCount > youTomeCount) {
            me.next++;
        } else if (meToYouCount < youTomeCount) {
            you.next++;
        } else {
            if (me.score < you.score) {
                you.next++;
            } else if (me.score > you.score) {
                me.next++;
            }
        }
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

        Map<Man, Integer> record = new HashMap<>();

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
