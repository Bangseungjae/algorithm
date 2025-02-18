package 프로그래머스.stack_queue._42626;


/*
섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
 */
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int sc : scoville) {
            queue.add(sc);
        }

        int answer = 1;

        while (queue.size() > 1) {
            queue.add(queue.poll() + (queue.poll() * 2));
            if (queue.peek() >= K) {
                return answer;
            }
            answer++;
        }

        return -1;
    }
}
