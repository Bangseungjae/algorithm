package 백준._2_실버.비트마스크.P1740;

import java.math.BigInteger;
import java.util.Scanner;

public class MainV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nStr = sc.nextLine().trim();

        BigInteger n = new BigInteger(nStr);
        String binaryStr = n.toString(2);

        BigInteger answer = new BigInteger(binaryStr, 3);
        System.out.println(answer);
    }
}
