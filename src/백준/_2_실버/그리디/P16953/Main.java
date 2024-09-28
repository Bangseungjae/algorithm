package 백준._2_실버.그리디.P16953;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(bfs(a, b));
    }

    // 최적값을 찾아서 반환한다.
    // 없을 시 -1을 반환
    private static int bfs(int a, int b) {
        int answer = -1;
        int sum = Integer.MAX_VALUE;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, a));
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.value == b) {
                sum = Math.min(sum, current.count);
            } else if (current.value < b) {
                Node n1 = new Node(current.count + 1, current.value * 2);
                queue.offer(n1);
                String s = current.value + "1";

                try {
                    Node n2 = new Node(current.count + 1, Integer.parseInt(s));
                    queue.offer(n2);
                } catch (Exception e) {

                }
            }
        }
        answer = sum == Integer.MAX_VALUE ? answer : sum;
        return answer;
    }

    static class Node {
        int count;
        int value;

        public Node(int count, int value) {
            this.count = count;
            this.value = value;
        }
    }
}
