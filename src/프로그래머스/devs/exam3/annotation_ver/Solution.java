package 프로그래머스.devs.exam3.annotation_ver;

class Solution {
    public int solution(String[] pouches) {
        int n = pouches.length;  // 주머니의 개수
        int maxPouches = 0;      // 최대 선택 가능한 주머니 수

        // 모든 가능한 주머니의 조합을 비트마스크로 탐색
        for (int i = 1; i < (1 << n); i++) {  // 1부터 2^n-1까지 반복
            int[] jellyCounts = new int[5];   // 'a'부터 'e'까지 젤리 개수를 세기 위한 배열
            int totalJellies = 0;             // 현재 조합에서의 젤리 총 개수

            // 현재 조합 i에서 어떤 주머니들을 포함할지 결정
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {  // i의 j번째 비트가 1이면 해당 주머니 포함
                    for (char jelly : pouches[j].toCharArray()) {  // 해당 주머니의 모든 젤리를 순회
                        jellyCounts[jelly - 'a']++;  // 젤리 종류에 해당하는 인덱스에 개수 증가
                        totalJellies++;  // 총 젤리 개수 증가
                    }
                }
            }

            int maxJellyCount = 0;  // 현재 조합에서 가장 많은 젤리 종류의 개수
            for (int count : jellyCounts) {
                maxJellyCount = Math.max(maxJellyCount, count);  // 가장 많은 젤리 개수 업데이트
            }

            // 조건을 만족하는지 확인 (한 종류의 젤리가 절반보다 많은 경우)
            if (maxJellyCount > totalJellies / 2) {
                maxPouches = Math.max(maxPouches, Integer.bitCount(i));  // 최대 선택 가능한 주머니 수 업데이트
            }
        }

        return maxPouches;  // 최대 선택 가능한 주머니 수 반환
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[]{"cab", "adaaa", "e"})); // 예상 출력: 3
        System.out.println(sol.solution(new String[]{"d", "a", "e", "d", "abdcc"})); // 예상 출력: 3
        System.out.println(sol.solution(new String[]{"a"})); // 예상 출력: 1
        System.out.println(sol.solution(new String[]{"aabb", "baba"})); // 예상 출력: 0
    }
}

