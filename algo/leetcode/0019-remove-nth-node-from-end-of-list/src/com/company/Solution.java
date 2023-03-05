package com.company;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode t = dummy;
        ListNode h = dummy;

        for (int i = 0; i <= n; i++) {
            t = t.next;
        }
        while (t != null) {
            t = t.next;
            h = h.next;
        }
        h.next = h.next.next;

        return dummy.next;
    }
}
