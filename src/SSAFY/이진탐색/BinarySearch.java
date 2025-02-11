package SSAFY.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).
                    mapToInt(Integer::parseInt).toArray();
            int P = temp[0];
            int Pa = temp[1];
            int Pb = temp[2];

            int aCount = search(P, Pa);
            int bCount = search(P, Pb);

            if (aCount > bCount) {
                System.out.println("#" + t + " " + "B");
            } else if (aCount < bCount) {
                System.out.println("#" + t + " " + "A");
            } else {
                System.out.println("#" + t + " " + 0);

            }
        }
    }

    private static int search(int page, int target) {
        int left = 1;
        int right = page;
        int mid = (left + right) / 2;
        int cnt = 0;

        while (true) {
            if (target == mid) {
                cnt += 1;
                return cnt;
            }

            if (target > mid) {
                left = mid;
                mid = (left + right) / 2;
                cnt += 1;
            } else if (target < mid){
                right = mid;
                mid = (left + right) / 2;
                cnt += 1;
            }
        }
    }
}
