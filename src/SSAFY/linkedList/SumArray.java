package SSAFY.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SumArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String[] input = br.readLine().split(" ");
            // 수열의 길이
            int N = Integer.parseInt(input[0]);
            // 수열의 개수
            int M = Integer.parseInt(input[1]);

            LinkedList<Integer> result = Arrays.stream(br.readLine().split(" ")).
                    map(Integer::parseInt).
                    collect(Collectors.toCollection(LinkedList::new));

            for (int i = 0; i < M - 1; i++){
                List<Integer> temp = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList();

                boolean flag = true;

                for (int value : result) {
                    if (value > temp.getFirst()) {
                        int idx = result.indexOf(value);


                        for (int j = 0; j < temp.size(); j++) {
                            result.add(idx + j, temp.get(j));
                        }
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    for (int value : temp) {
                        result.addLast(value);
                    }
                }

            }
            int resultSize = result.size();

            System.out.print("#" + t + " ");
            for (int j = resultSize - 1; j >= resultSize - 10; j--) {
                System.out.print(result.remove(j) + " ");
            }
            System.out.println();
        }
    }
}
