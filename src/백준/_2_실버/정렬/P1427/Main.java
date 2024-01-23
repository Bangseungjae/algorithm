package 백준._2_실버.정렬.P1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(Integer.parseInt(str.substring(i, i + 1)));
        }
        list.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        list.forEach(x -> sb.append(x));
        System.out.println(sb);
    }
}
