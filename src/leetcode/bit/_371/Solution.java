package leetcode.bit._371;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
// 4ms
//class Solution {
//    public int getSum(int a, int b) {
//        //정수형 32비트 이진수 문자열로 변환
//        String binA = String.format("%32s", Integer.toBinaryString(a)).replace(' ', '0');
//        String binB = String.format("%32s", Integer.toBinaryString(b)).replace(' ', '0');
//
//        List<Character> result = new ArrayList<>();
//        int carry = 0;
//        int sum;
//
//        // 32비트 모든 자리를 뒤에서 부터 계산
//        for (int i = 0; i < 32; i++) {
//            int A = Character.getNumericValue(binA.charAt(31 - i));
//            int B = Character.getNumericValue(binB.charAt(31 - i));
//
//            // 전가산기 구현
//            int Q1 = A & B;
//            int Q2 = A ^ B;
//            int Q3 = Q2 & carry;
//            sum = carry ^ Q2;
//            carry = Q1 | Q3;
//            result.addFirst(Character.forDigit(sum, 2));
//        }
//        return Integer.parseUnsignedInt(result.stream().map(String::valueOf).collect(Collectors.joining("")), 2);
//    }
//}

// 0ms
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
