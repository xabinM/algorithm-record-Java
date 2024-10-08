import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.Stack;

public class baek1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strings = br.readLine();

        // 스택으로 변환
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (char ch : strings.toCharArray()){
            leftStack.push(ch);
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++){
            String[] command = br.readLine().split(" ");

            switch (command[0]){
                case "L":
                    if (!leftStack.isEmpty()){
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case "D":
                    if (!rightStack.isEmpty()){
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case "B":
                    if (!leftStack.isEmpty()){
                        leftStack.pop();
                    }
                    break;
                case "P":
                    leftStack.push(command[1].charAt(0));
                    break;
            }
        }
        // 결과 출력
        StringBuilder result = new StringBuilder();
        for (char ch : leftStack){
            result.append(ch);
        }
        while (!rightStack.isEmpty()){
            result.append(rightStack.pop());
        }

        System.out.println(result.toString());
    }


    // 시간 초과 코드 ( 아마 입력 시간 초과인듯?)
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String strings = scanner.nextLine();
//
//        // 스택으로 변환
//        Stack<Character> leftStack = new Stack<>();
//        Stack<Character> rightStack = new Stack<>();
//
//        // 초기 문자열을 왼쪽 스택에 담기
//        for (char ch : strings.toCharArray()){
//            leftStack.push(ch);
//        }
//
//        int M = scanner.nextInt();
//        scanner.nextLine(); // 명령어 입력 전의 개행 처리
//
//        // 명령어 처리
//        for (int i = 0; i < M; i++){
//            String command = scanner.nextLine();
//
//            if (command.startsWith("L")){
//                if (!leftStack.isEmpty()){
//                    rightStack.push(leftStack.pop());
//                }
//            } else if (command.startsWith("D")) {
//                if (!rightStack.isEmpty()){
//                    leftStack.push(rightStack.pop());
//                }
//            } else if (command.startsWith("B")) {
//                if (!leftStack.isEmpty()){
//                    leftStack.pop();
//                }
//            } else if (command.startsWith("P")) {
//                char x = command.charAt(2);
//                leftStack.push(x);
//            }
//        }
//
//        // 결과 출력
//        StringBuilder result = new StringBuilder();
//        for (char ch : leftStack){
//            result.append(ch);
//        }
//        while (!rightStack.isEmpty()){
//            result.append(rightStack.pop());
//        }
//
//        System.out.println(result.toString());
//    }
}