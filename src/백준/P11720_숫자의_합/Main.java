package 백준.P11720_숫자의_합;


/**
 * 자료구조 문제입니다.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Integer n = Integer.parseInt(sc.next());
        String str = sc.next();

        char[] chars = str.toCharArray();
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += chars[i] - 48;

        }
        System.out.println(sum);
    }
}
