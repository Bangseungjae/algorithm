package 백준._1_브론즈.정렬.P10989;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        int[] A = new int[10001];
        for (int i = 0; i < N; i++) {
            A[Integer.parseInt(bf.readLine())]++;
        }
        for (int i = 0; i < 10001; i++) {
            while (A[i] > 0) {
                bw.write(i + "\n");
                A[i]--;
            }
        }
        bw.flush();
        bw.close();
    }
}
