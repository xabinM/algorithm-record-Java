package SSAFY.미정;

import java.util.Scanner;

public class MinMax {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			
			int maxValue = Integer.MIN_VALUE;
			int minValue = Integer.MAX_VALUE;
			
			for (int j = 0; j < N; j++) {
				int cur = sc.nextInt();

				
				if (cur > maxValue) {
					maxValue = cur;
				}
				
				if (cur < minValue) {
					minValue = cur;
				}
				
				
			}
			int result = maxValue - minValue;
			
			System.out.println("#" + (i + 1) + " " + result);
		}
	}
}
