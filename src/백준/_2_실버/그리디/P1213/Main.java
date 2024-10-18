package 백준._2_실버.그리디.P1213;

import java.io.*;
import java.util.*;

public class Main {
    private static final String ERR_MESSAGE = "I'm Sorry Hansoo";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : input.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        Queue<Node> queue = new PriorityQueue<>();
        char[] chars = new char[input.length()];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value % 2 == 1) {
                queue.offer(new Node(entry.getKey(), 1));
            }
            int count = value / 2;
            for (int i = 0; i < count; i++) {
                queue.offer(new Node(entry.getKey(), 2));
            }
        }

        if (queue.isEmpty()) {
            System.out.println(ERR_MESSAGE);
            return;
        }

        if (input.length() % 2 != 0) { // 홀수
            int mid = input.length() / 2;
            Node cur = queue.poll();
            if (cur.cnt != 1) {
                System.out.println(ERR_MESSAGE);
                return;
            }
            chars[mid] = cur.ch;

            for (int i = 1; i + mid < input.length() && mid - i > -1; i++) {
                cur = queue.poll();
                assert cur != null;
                if (cur.cnt != 2) {
                    System.out.println(ERR_MESSAGE);
                    return;
                }
                chars[mid - i] = cur.ch;
                chars[mid + i] = cur.ch;
            }

        } else { // 짝수
            int leftMid = input.length() / 2 - 1;
            int rightMid = leftMid + 1;
            for (int i = 0; i + rightMid < input.length() && leftMid - i > -1; i++) {
                Node cur = queue.poll();
                if (cur.cnt != 2) {
                    System.out.println(ERR_MESSAGE);
                    return;
                }
                chars[leftMid - i] = cur.ch;
                chars[rightMid + i] = cur.ch;
            }
        }

        System.out.println(String.valueOf(chars));
    }
}
/*
2로 나눠서 몫만큼 2씩 저장해주고 나머지가 1이면 1로 저장
 */

class Node implements Comparable<Node>{
    char ch;
    int cnt;

    public Node(char ch, int cnt) {
        this.ch = ch;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Node o) {
        if (this.cnt == o.cnt) {
            return o.ch - this.ch;
        }
        return this.cnt - o.cnt;
    }
}
