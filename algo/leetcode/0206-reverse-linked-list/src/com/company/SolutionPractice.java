package com.company;

public class SolutionPractice {
    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode node = head;    
        while (node != null) {
            ListNode nextNode = node.next;
            node.next = prevNode;
            prevNode = node;
            node = nextNode;
        }
        return prevNode;
    }
}
