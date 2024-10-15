package 프로그래머스.카카오._2023KAKAO_BLIND.택배_배달과_수거하기;

class SolutionV2 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliver = 0, pickup = 0;
        for(int i = n-1; i >= 0; i--){
            deliver += deliveries[i];
            pickup += pickups[i];
            while (deliver > 0 || pickup > 0){
                deliver -= cap;
                pickup -= cap;
                answer += (i+1) * 2L;
            }

        }
        return answer;
    }
}
