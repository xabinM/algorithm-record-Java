package SSAFY.tree;

import java.util.Scanner;

public class SubTree {
    private static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int E = sc.nextInt();
            int N = sc.nextInt();

            int[] childArr = new int[E + 2];

            for (int i = 0; i < E; i++) {
                int parent = sc.nextInt();
                int child = sc.nextInt();

                childArr[child] = parent;
            }

            int cur = N;
            cnt = 1;

            for (int i = 1; i < childArr.length; i++) {
                if (childArr[i] == cur) {
                    count(childArr, cur, i);
                }
            }

            System.out.println("#" + t + " " + cnt);
        }
    }

    private static void count(int[] childArr, int cur, int idx) {
        if (cur != 0) {
            cur = idx;
            cnt++;
            for (int i = 1; i < childArr.length; i++){
                if (childArr[i] == cur){
                    count(childArr, cur, i);
                }
            }
        }
    }
}

//    private void inorder()
//    {
//        //탈출시 값읗 넣어주고
//        if()
//        {
//            9/6-4
//        }0
//        inorder();
//        //
//        inorder();
//        //계산을 해준다. ( 스택에서 2만꺼내서
//
//    }
