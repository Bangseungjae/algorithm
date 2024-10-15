package 코드트리.트리;

import java.util.*;



/*
문제: 트리에서 한칸 내려갈 때마다 현재 인덱스 위치에서 + 1 혹은 0만 가능하다.
     최대한 적은 값으로 맨 위칸에서 맨 아래칸까지의 값의 합을 구하라.

    2
   5 3
  2 4 5
 4 3 6 9

 답 -> 2 + 3 + 2 + 3 = 11

 input: [[2], [5, 3], [2, 4, 5], [4, 3, 6, 9]]
 output: 10

 input: [[-10]]
 output: -10
 */

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        int[][] arr = new int[][]{
                {2},
                {5, 3},
                {2, 4, 5},
                {4, 3, 6, 9},
        };
//        int[][] arr = new int[][]{
//                {-2},
//        };
        for (int i = 0; i < arr.length; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                list.get(i).add(arr[i][j]);
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(list));
    }
}

class Solution {
    public int solution(List<List<Integer>> list) {
        if (list.isEmpty()) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, list.get(0).get(0)));
        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.x == list.size() - 1) {
                min = Math.min(min, current.value);
                continue;
            }
            int nextX = current.x + 1;
            for (int i = 0; i < list.get(nextX).size(); i++) {
                if (Math.abs(i - current.y) <= 1) {
                    queue.offer(new Node(nextX, i, current.value + list.get(nextX).get(i)));
                }
            }
        }
        return min;
    }
}

class Node {
    int x;
    int y;
    int value;

    public Node(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
