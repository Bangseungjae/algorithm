package 프로그래머스.나눗셈;

class Solution {
    public int solution(int n, int k) {
        if (k == 1 || n % k == 0) return 1;  // 빠른 종료

        int d = String.valueOf(n).length();   // 자리수
        System.out.printf("d: %d\n", d);
        long pow = 1;                         // 10^d (mod k)
        for (int i = 0; i < d; i++) {
            System.out.printf("pow: %d\n", pow);
            pow = (pow * 10) % k;
        }

        long rem = 0;
        for (int m = 1; m <= k; m++) {        // 최대 k번
            rem = (rem * pow + n) % k;
            System.out.printf("rem: %d \n", rem);
            if (rem == 0) return m;           // 최소 m 발견
        }
        return -1;                            // 존재하지 않음
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(22, 9));
    }
}


