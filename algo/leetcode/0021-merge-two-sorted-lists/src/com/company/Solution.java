package com.company;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode cursor = null;

        while (l1 != null || l2 != null) {
            Integer val = null;
            if (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    val = l2.val;
                    l2 = l2.next;
                } else {
                    val = l1.val;
                    l1 = l1.next;
                }
            } else if (l1 != null && l2 == null) {
                val = l1.val;
                l1 = l1.next;
            } else if (l2 != null && l1 == null) {
                val = l2.val;
                l2 = l2.next;
            }

            if (val != null) {
                if (cursor == null) {
                    result = new ListNode(val);
                    cursor = result;
                } else {
                    cursor.next = new ListNode(val);
                    cursor = cursor.next;
                }
            }
        }

        return result;
    }
}