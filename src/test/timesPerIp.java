package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class timesPerIp {
    private static final Map<String, List<Long>> timesPerIP = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputs = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null && !line.equals("END")) {
            inputs.add(line);
        }

        for (String input : inputs) {
            int abusingFlag = isAbusing(input);
            System.out.println(abusingFlag);
        }
    }

    public static int isAbusing(String input) {
        String[] parts = input.split(",");
        long curTime = Long.parseLong(parts[0]);
        String curtIp = parts[2];

        // 현재 IP의 요청 시간 리스트 가져오기 (없으면 새로 생성)
        timesPerIP.putIfAbsent(curtIp, new ArrayList<>());
        List<Long> times = timesPerIP.get(curtIp);

        // 현재 요청 시간 추가
        times.add(curTime);

        // 60초 이내의 요청 개수 세기
        int cnt = 0;
        for (long time : times) {
            if (curTime >= time && curTime - 59 <= time) {
                cnt++;
            }
        }

        // 10번 초과시 어뷰징
        return cnt > 10 ? 1 : 0;
    }
}