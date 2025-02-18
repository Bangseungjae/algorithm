package leetcode.linkedlist._206;

import leetcode.linkedlist.ListNode;

/**
 * input: head -> 1, 2, 3, 4, 5
 * output: 5, 4, 3, 2, 1
 */

/**
 * 42.48MB
 */
//class Solution {
//    public ListNode reverseList(ListNode head) {
//        return reverse(head, null);
//    }
//    private ListNode reverse(ListNode node, ListNode prev) {
//        if (node == null) {
//            return prev;
//        }
//        ListNode next = node.next;
//        // 현재 노드의 다음으로 이전 노드 지정
//        node.next = prev;
//        return reverse(next, node);
//    }
//}


/**
 * 42.41 MB
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, node = head;

        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}


/*
   1: next: 2, cur.next = null, rev = 1, cur = 2
   2: next: 3, cur.next = 1, rev = 2, cur = 3
   3: next: 4, cur.next = 2
 */