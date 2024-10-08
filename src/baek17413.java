import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 17413
public class baek17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        sc.close();

        solution(S);
    }

    public static void solution(String S){
        boolean tagStatus = false;
        List<String> temp = new ArrayList<>();
        List<String> result = new ArrayList<>();

        for (char i : S.toCharArray()){
            if (tagStatus){
                if (i == '>'){
                    result.add(String.join("", temp));
                    result.add(Character.toString(i));
                    temp.clear();
                    tagStatus = false;
                } else{
                    temp.add(Character.toString(i));
                }
            } else {
                if (i == '<'){
                    result.add(new StringBuilder(String.join("", temp)).reverse().toString());
                    result.add(Character.toString(i));
                    temp.clear();
                    tagStatus = true;
                } else if (i == ' ') {
                    result.add(new StringBuilder(String.join("", temp)).reverse().toString());
                    result.add(Character.toString(i));
                    temp.clear();
                } else {
                    temp.add(Character.toString(i));
                }
            }
        }
        if (!temp.isEmpty()){
            result.add(new StringBuilder(String.join("", temp)).reverse().toString());
        }

        System.out.println(String.join("", result));
    }

}