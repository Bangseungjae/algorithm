package codility;

public class Exam1 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("rs = " + solution.solution(1041));

    }

    static class Solution {
        public int solution(int N) {
            String binaryString = Integer.toBinaryString(N);
            int length = binaryString.length();

            int max = 0;
            int current = 0;
            String[] arr = binaryString.split("");
            for (int i = 0; i < length; i++) {
                if (arr[i].equals("0")) {
                    current++;
                } else {
                    max = current > max ? current : max;
                    current = 0;
                }
            }
            return max;
        }
    }
}
