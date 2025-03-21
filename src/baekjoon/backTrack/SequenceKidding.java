package baekjoon.backTrack;

import java.util.*;
import java.util.stream.Collectors;

public class SequenceKidding {
    private static Deque<String> splited;
    private static Set<String> result = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        splited.addAll(Arrays.asList(input.split("")));

        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        while (!splited.isEmpty()) {
            String temp = splited.pollFirst();

        }
    }

    private static void backTrack( ) {

    }
}
