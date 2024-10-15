package 프로그래머스.카카오._2023KAKAO_BLIND.택배_배달과_수거하기;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long totalDistance = 0;
        int deliveryIndex = n - 1; // 배달이 필요한 가장 먼 집의 인덱스
        int pickupIndex = n - 1;   // 수거가 필요한 가장 먼 집의 인덱스

        while (deliveryIndex >= 0 || pickupIndex >= 0) {
            // 배달 및 수거가 필요한 가장 먼 집 찾기
            while (deliveryIndex >= 0 && deliveries[deliveryIndex] == 0) {
                deliveryIndex--;
            }
            while (pickupIndex >= 0 && pickups[pickupIndex] == 0) {
                pickupIndex--;
            }

            // 모든 배달 및 수거가 완료되었다면 종료
            if (deliveryIndex < 0 && pickupIndex < 0) {
                break;
            }

            // 이번에 이동할 가장 먼 거리 계산 (0부터 시작하므로 +1)
            int furthestHouse = Math.max(deliveryIndex, pickupIndex);
            totalDistance += (furthestHouse + 1) * 2L; // 왕복 거리

            // 배달 과정
            int deliverCapacity = cap;
            for (int i = deliveryIndex; i >= 0 && deliverCapacity > 0; i--) {
                if (deliveries[i] > 0) {
                    int deliverable = Math.min(deliveries[i], deliverCapacity);
                    deliveries[i] -= deliverable;
                    deliverCapacity -= deliverable;
                }
            }

            // 수거 과정
            int pickupCapacity = cap;
            for (int i = pickupIndex; i >= 0 && pickupCapacity > 0; i--) {
                if (pickups[i] > 0) {
                    int pickable = Math.min(pickups[i], pickupCapacity);
                    pickups[i] -= pickable;
                    pickupCapacity -= pickable;
                }
            }
        }

        return totalDistance;
    }
}
