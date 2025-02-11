package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            int T = Integer.parseInt(br.readLine());
            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j < 100; j++){
                List<Integer> temp = Stream.of(br.readLine().split(" ")).
                        map(Integer::parseInt).
                        collect(Collectors.toList());
                graph.add(temp);
            }

            int leftCross = 0;
            int rightCross = 0;

            List<Integer> result = new ArrayList<>();
            for (int x = 0; x < 100; x++) {
                int row = graph.get(x).stream().mapToInt(Integer::intValue).sum();
                result.add(row);

                for (int y = 0; y < 100; y++) {
                    if (y == 0) {
                        result.add(graph.get(x).get(y));
                    }
                    if (x == y) {
                        leftCross += graph.get(x).get(y);
                    }
                    if (x + y == 99) {
                        rightCross += graph.get(x).get(y);
                    }
                }
            }

            result.add(leftCross);
            result.add(rightCross);
            System.out.println("#" + T + " " + Collections.max(result));
        }
    }
}
