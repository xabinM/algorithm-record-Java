package SSAFY.미정;

import java.util.Scanner;

public class RangeSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] arr = new int[N];
			for (int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
			}

			int result = 0;
			int sumMin = Integer.MAX_VALUE;
			int sumMax = Integer.MIN_VALUE;;
			
			for (int k = 0; k <= N - M; k++) {
				int cur = 0;
				for (int x = 0; x < M; x++) {
					cur += arr[k + x];
				}

				if (cur > sumMax) {
					sumMax = cur;
				}
				
				if (cur < sumMin) {
					sumMin = cur;
				}
			}
			result = sumMax - sumMin;
			
			System.out.println("#" + (i + 1) + " " + result);
		}
	}
}