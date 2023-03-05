package com.company;

public class SolutionPractice2 {
    public boolean hasCycle(ListNode head) {
        if (head == null) { return false; }
        ListNode fast = head.next, slow = head;
        if (fast != null) {
            fast = fast.next;
        }
        
        while (fast != null) {
            fast = fast.next;
            if (fast == slow) {
                return true;
            }

            if (fast != null) {
                fast = fast.next;
                if (fast == slow) {
                    return true;
                }
            }

            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
