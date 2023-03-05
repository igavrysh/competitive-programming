package com.company;

public class SolutionPractice2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode endPointer = head;
        int i = 1;
        while (i < n) {
            if (endPointer == null) {
                return null;
            }
            endPointer = endPointer.next;
            i++;
        }
        ListNode senti = new ListNode(-1, head);
        ListNode prevNode = senti;
        ListNode node = head;
        while (endPointer.next != null) {
            endPointer = endPointer.next;
            prevNode = node;
            node = node.next;
        }
        prevNode.next = node.next;
        return senti.next;
    }
}
