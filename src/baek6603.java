import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class baek6603 {
    public static void main(String[] args) {
        int[] intArray = {1,2,3,4,5,6};
        char[] charArray = {'a', 'b', 'c', 'd'};

        System.out.println("intArray : " + intArray);
        System.out.println("charArray : " + charArray);
        System.out.println("intArray : " + Arrays.toString(intArray));
        System.out.println("charArray : " + Arrays.toString(charArray));
    }
//    static int T;
//    static int[] S;
//
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        while (true) {
//            T = sc.nextInt();
//
//            if (T == 0){
//                break;
//            }
//
//            S = new int[T];
//
//            for (int i = 0; i < T; i++) {
//                S[i] = sc.nextInt();
//            }
//
//            int[] temp = new int[6];
//            int start = 0;
//            int depth = 0;
//            backTrack(start, depth, temp, T, S);
//            System.out.println();
//        }
//
//        sc.close();
//    }
//
//    public static void backTrack(int start, int depth, int[] temp, int T, int[] S){
//
//        if (depth == 6) {
////            System.out.println(Arrays.toString(temp).replaceAll("[\\[\\],]", "")); // String으로 변환후 정규식을 사용한 replace로 처리
//            System.out.println((Arrays.stream(temp).mapToObj(String::valueOf).collect(Collectors.joining(" ")))); //
//            return;
//        }
//
//        for (int i = start; i < T; i++){
//            temp[depth] = S[i];
//            backTrack(i + 1, depth + 1, temp, T, S);
//        }
//    }
}