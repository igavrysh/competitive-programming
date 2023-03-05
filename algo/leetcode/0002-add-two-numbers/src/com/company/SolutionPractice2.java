package com.company;

public class  SolutionPractice2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0), node = result;
        while (l1 != null || l2 != null || carry != 0) {
            int inc = carry;
            if (l1 != null) {
                inc += l1.val;
                l1 = l1.next;
            } 
            if (l2 != null) {
                inc += l2.val;
                l2 = l2.next; 
            }
            node.next = new ListNode(inc % 10);
            node = node.next;
            carry = inc / 10;
        }
        return result.next;
    }
}
