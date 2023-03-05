package com.company;

public class SolutionOptimized {
    public void reorderList(ListNode head) {
        // find middle node and split list into two list
        ListNode middleNode = head, endNode = head;
        ListNode prevNode = null;
        while (endNode != null) {
            prevNode = middleNode;
            middleNode = middleNode.next;
            endNode = endNode.next;
            if (endNode != null) {
                endNode = endNode.next;
            }
        }
        if (prevNode != null) prevNode.next = null;

        // reverse the second list
        ListNode node = middleNode;
        prevNode = null;
        while (node != null) {
            ListNode nextNode = node.next;
            node.next = prevNode;
            prevNode = node;
            node = nextNode;
        }

        // merge two lists
        node = head;
        ListNode revNode = prevNode;
        while (revNode != null) {
            ListNode nextNode = node.next;
            ListNode nextRevNode = revNode.next;
            node.next = revNode;
            revNode.next = nextNode;
            node = nextNode;
            revNode = nextRevNode;
        }
    }
}
