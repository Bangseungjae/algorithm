package 백준.P12891_DNA_비밀번호;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        char[] chars = "ACGT".toCharArray();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int P = Integer.parseInt(st.nextToken()); // 문자열의 길이
        int S = Integer.parseInt(st.nextToken()); // 부분 문자열의 길이

        String DNA = bf.readLine();
        char[] DnaArray = DNA.toCharArray();

        // {'A', 'C', 'G', 'T'} 의 최소 개수
        Integer[] arr = new Integer[4];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i<4; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Integer[] A = {0, 0, 0, 0};
        for (int i = 0; i < S; i++) {
            if (DnaArray[i] == chars[0]) {
                A[0]++;
            }
            if (DnaArray[i] == chars[1]) {
                A[1]++;
            }
            if (DnaArray[i] == chars[2]) {
                A[2]++;
            }
            if (DnaArray[i] == chars[3]) {
                A[3]++;
            }
        }

        int count = 0;
        int j = S;
        for (int i = 0; i<P-S; i++) {
            if (A[0] >= arr[0] && A[1] >= arr[1] && A[2] >= arr[2] && A[3] >= arr[3]) {
                count++;
            }
            if (DnaArray[i] == chars[0]) {
                A[0]--;
            }
            if (DnaArray[i] == chars[1]) {
                A[1]--;
            }
            if (DnaArray[i] == chars[2]) {
                A[2]--;
            }
            if (DnaArray[i] == chars[3]) {
                A[3]--;
            }

            if (DnaArray[j] == chars[0]) {
                A[0]++;
            }
            if (DnaArray[j] == chars[1]) {
                A[1]++;
            }
            if (DnaArray[j] == chars[2]) {
                A[2]++;
            }
            if (DnaArray[j] == chars[3]) {
                A[3]++;
            }
            j++;
        }
        if (A[0] >= arr[0] && A[1] >= arr[1] && A[2] >= arr[2] && A[3] >= arr[3]) {
            count++;
        }
        System.out.println(count);
        bf.close();
    }
}
