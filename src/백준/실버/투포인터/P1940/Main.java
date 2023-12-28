package 백준.실버.투포인터.P1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        List<Integer> ingredientList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ingredientList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(ingredientList);
        int i = 0;
        int j = N - 1;
        int count = 0;
        while (i < j) {
            int sum = ingredientList.get(i) + ingredientList.get(j);
            if (sum == M) {
                i++;
                j--;
                count++;
            } else if (sum < M) {
                i++;
            } else {
                j--;
            }
        }
        System.out.println(count);
        bf.close();
    }
}
