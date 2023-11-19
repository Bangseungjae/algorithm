package 프로그래머스.완전탐색.소수찾기;

import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839?language=java
 */

public class Main {
    public static void main(String[] args) {
        int solution = new Solution().solution("17");
        System.out.println(solution);
    }



}
class Solution {
    public int solution(String numbers) {
        Set<Integer> primes = new HashSet<>();
        int[] nums = numbers.chars()
                .map(c -> c - '0')
                .toArray();
        return getPrimes(
                0,
                nums,
                new boolean[nums.length],
                primes
        ).size();
    }

    /**
     *
     * @param acc - 지금까지 만들어 놓은 숫자
     * @param numbers - 사용할 수 있는 종이 조각들
     * @param isUsed
     * @param primes
     * @return
     */
    private Set<Integer> getPrimes(
            int acc,
            int[] numbers,
            boolean[] isUsed,
            Set<Integer> primes
    ) {
        if (isPrime(acc)) primes.add(acc);

        for (int i = 0; i < numbers.length; i++) {
            if (isUsed[i]) continue;
            int nextAcc = acc * 10 + numbers[i];
            isUsed[i] = true;
            getPrimes(nextAcc, numbers, isUsed, primes);
            isUsed[i] = false;
        }
        return primes;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
