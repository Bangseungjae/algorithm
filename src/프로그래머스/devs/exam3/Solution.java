package 프로그래머스.devs.exam3;

class Solution {
    public int solution(String[] pouches) {
        int n = pouches.length;
        int maxPouches = 0;

        for (int i = 1; i < (1 << n); i++) {
            int[] jellyCounts = new int[5];
            int totalJellies = 0;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    for (char jelly : pouches[j].toCharArray()) {
                        jellyCounts[jelly - 'a']++;
                        totalJellies++;
                    }
                }
            }

            int maxJellyCount = 0;
            for (int count : jellyCounts) {
                maxJellyCount = Math.max(maxJellyCount, count);
            }

            if (maxJellyCount > totalJellies / 2) {
                maxPouches = Math.max(maxPouches, Integer.bitCount(i));
            }
        }

        return maxPouches;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[]{"cab", "adaaa", "e"})); // 3
        System.out.println(sol.solution(new String[]{"d", "a", "e", "d", "abdcc"})); // 3
        System.out.println(sol.solution(new String[]{"a"})); // 1
        System.out.println(sol.solution(new String[]{"aabb", "baba"})); // 0
    }
}
