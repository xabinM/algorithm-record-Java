import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MiddleAverageValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			List<Integer> arr = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                arr.add(sc.nextInt());
            }
            arr.sort(null);

            int sum = 0;

            for (int k = 1; k < 9; k++) {
                sum += arr.get(k);
            } 
			
            int avg = (int )Math.round(sum / 8.0);
			System.out.println("#" + (i + 1) + " " + avg);
		}
    }
}
