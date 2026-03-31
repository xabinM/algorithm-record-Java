package programmers.lv2;

import java.util.Arrays;

public class Lifeboat {

    public static void main(String[] args) {

    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int answer = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            answer++;
        }

        return answer;
    }
}
