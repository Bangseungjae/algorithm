package 백준._2_실버.정렬.P11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort(Comparator.naturalOrder());
//        int sum = 0;
        for (int i = 1; i < N; i++) {
            list.set(i, list.get(i - 1) + list.get(i));
        }
        System.out.println(list.stream().reduce(0, Integer::sum));
    }
}
