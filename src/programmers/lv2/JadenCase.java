package programmers.lv2;

public class JadenCase {

    public static void main(String[] args) {


        String s = "3people  unFollowed me ";

        System.out.println(solution(s));
    }

    public static String solution(String s) {

        String[] splitS = s.split(" ", -1);

        for (int i = 0; i < splitS.length; i++) {
            String[] temp =  splitS[i].split("");

            temp[0] = temp[0].toUpperCase();

            for (int j = 1; j < temp.length; j++) {
                temp[j] = temp[j].toLowerCase();
            }

            StringBuilder sb = new StringBuilder();

            for (String cur : temp) {
                sb.append(cur);
            }

            splitS[i] = sb.toString();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splitS.length; i++) {
            sb.append(splitS[i]);

            if (i != splitS.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
