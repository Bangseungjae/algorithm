package 백준._3_골드.정수론.P11689;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bf.readLine());
        long result = n;

        for (long p = 2; p <= Math.sqrt(n); p++) {
            if (n % p == 0) {
                result -= result / p;
                while (n % p == 0) {
                    n /= p;
                }
            }
        }
        if (n > 1)
            result -= result / n;
        System.out.println(result);

    }
}
