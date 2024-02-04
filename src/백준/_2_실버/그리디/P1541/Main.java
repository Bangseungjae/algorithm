package 백준._2_실버.그리디.P1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();
        String[] split = str.split("-");
        for (int i = 0; i < split.length; i++) {
            String[] m = split[i].split("[+]");
            int n = 0;
            for (String s : m) {
                n += Integer.parseInt(s);
            }
            split[i] = String.valueOf(n);
        }

        int sum = 0;
        for (int i = 0; i < split.length; i++) {
            if (i == 0) {
                sum += Integer.parseInt(split[i]);
            } else {
                sum -= Integer.parseInt(split[i]);
            }
        }
        System.out.println(sum);
    }
}
