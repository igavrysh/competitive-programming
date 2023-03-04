package com.company;

public class SolutionRecursive {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode[] output = new ListNode[1];
        intReverseList(head, output, head);
        return output[0];
    }

    private void intReverseList(ListNode node, ListNode[] newHead, ListNode oldNodeHead) {
        if (node.next != null) {
            intReverseList(node.next, newHead, oldNodeHead);
        } else {
            newHead[0] = node;
        }

        if (node.next != null) {
            node.next.next = node;
        }

        if (node == oldNodeHead) {
            node.next = null;
        }
    }
}