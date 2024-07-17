package goorm.이카운트.하늘다리;

import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            boolean isOk = false;
            if (map.containsKey(height)) {
                isOk = true;
                Integer index = map.get(height);
                for (int j = index + 1; j < i; j++) {
                    if (arr[j] > height) {
                        isOk = false;
                        break;
                    }
                }
            }
            if (isOk) {
                count++;
            }
            map.put(height, i);
            arr[i] = height;
        }

        System.out.println(count);
    }
}
