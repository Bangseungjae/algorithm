package 백준._1_브론즈.수학.조합.P13251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        double rs = 0.0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        int K = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            int s = sum;
            int count = K;
            double temp = 1;
            while (count != 0) {
                temp *= (double) arr[i] / s;
                arr[i]--;
                count--;
                s--;
            }
            rs += temp;
        }
        System.out.println(rs);
    }
}
