package 백준._2_실버.자료구조.P1620;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer, String> map1 = new HashMap<>(100_000);
        Map<String, Integer> map2 = new HashMap<>(100_000);

        for (int i = 1; i < N + 1; i++) {
            String str = br.readLine();
            map1.put(i, str);
            map2.put(str, i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (Character.isDigit(str.charAt(0))) {
                int key = Integer.parseInt(str);
                String value = map1.get(key);
                stringBuilder.append(value).append("\n");
            } else {
                Integer value = map2.get(str);
                stringBuilder.append(value).append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
}

/*
N: 포켓몬의 개수
M: 맞춰야 하는 문제의 개수
 */
