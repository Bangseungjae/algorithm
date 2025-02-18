package leetcode.stack_queue._23;

import leetcode.linkedlist.ListNode;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(((o1, o2) -> {
            if (o1.val == o2.val)
                return 0;
            else if (o1.val > o2.val)
                return 1;
            else
                return -1;
        }));
        ListNode root = new ListNode(0);
        ListNode tail = root;
        // 각 연결 리스트의 첫 번째 노드를 큐에 저장
        for (ListNode node : lists)
            if (node != null)
                pq.add(node);

        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;

            // 추출한 연결 리스트의 다음 노드는 다시 큐에 저장
            if (tail.next != null) {
                pq.add(tail.next);
            }
        }
        return root.next;
    }
}
