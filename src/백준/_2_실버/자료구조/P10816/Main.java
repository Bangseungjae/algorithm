package 백준._2_실버.자료구조.P10816;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer key = Integer.parseInt(st.nextToken());
            if (map.containsKey(key)) {
                Integer i1 = map.get(key);
                map.put(key, i1 + 1);
            } else {
                map.put(key, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            Integer key = Integer.parseInt(st.nextToken());
            if (map.containsKey(key)) {
                Integer value = map.get(key);
                sb.append(value).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}
