import java.util.Scanner;

public class MaxValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int maxValue = Integer.MIN_VALUE;
			
			for (int j = 0; j < 10; j++) {
				int cur = sc.nextInt();

				
				if (cur > maxValue) {
					maxValue = cur;
				}
			}
			int result = maxValue;
			
			System.out.println("#" + (i + 1) + " " + result);
		}
    }
}
