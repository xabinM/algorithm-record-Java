import java.util.*;

// 12904
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder S = new StringBuilder(sc.nextLine());
        StringBuilder T = new StringBuilder(sc.nextLine());

        solution(S, T);
        System.out.println(bfs(S, T));

        sc.close();
    }

    public static void solution(StringBuilder S, StringBuilder T){

        while (T.length() > S.length()){
            if (T.charAt(T.length() - 1) == 'A'){
                T.deleteCharAt(T.length() - 1);
            } else {
                T.deleteCharAt((T.length() - 1));
                T.reverse();
            }
        }

        if (T.toString().equals(S.toString())){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static int bfs(StringBuilder S, StringBuilder T){

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(T.toString());
        visited.add(T.toString());

        while (!q.isEmpty()){
            StringBuilder cur = new StringBuilder(q.poll());

            if (cur.toString().contentEquals(S)){
                return 1;
            }

            if (cur.length() > S.length()) {
                if (cur.charAt(cur.length() - 1) == 'A') {
                    cur.deleteCharAt(cur.length() - 1);
                    if (!visited.contains(cur.toString())) {
                        visited.add(cur.toString());
                        q.add(cur.toString());
                    }
                } else {
                    cur.deleteCharAt(cur.length() - 1).reverse();
                    if (!visited.contains(cur.toString())) {
                        visited.add(cur.toString());
                        q.add(cur.toString());
                    }

                }
            }
        }
        return 0;
    }
}