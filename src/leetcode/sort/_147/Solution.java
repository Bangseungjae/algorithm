package leetcode.sort._147;

import leetcode.linkedlist.ListNode;

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode parent = new ListNode();
        ListNode p = parent;

        while (head != null) {
            while (p.next != null && p.next.val < head.val)
                p = p.next;
            ListNode pNext = p.next;
            ListNode headNext = head.next;
            p.next = head;
            head.next = pNext;
            head = headNext;
            if (head != null && p.val > head.val) {
                p = parent;
            }
        }
        return parent.next;
    }
}
