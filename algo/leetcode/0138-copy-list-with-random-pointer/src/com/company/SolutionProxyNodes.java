package com.company;

public class SolutionProxyNodes {
    public Node copyRandomList(Node head) {
        if (head == null) { return null; }
        Node node = head;
        Node newNode = null;
        while (node != null) {
            newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
            node = node.next.next;
        }

        node = head;
        while (node != null) {
            newNode = node.next;
            if (node.random != null) {
                newNode.random = node.random.next;
            }
            node = node.next.next;
        }

        Node newHead = head.next;
        node = head;
        newNode = newHead;
        while (node != null) {
            Node nodeNextNext = node.next.next;
            Node newNodeNextNext = newNode.next != null ? newNode.next.next : null;

            node.next = nodeNextNext;
            newNode.next = newNodeNextNext;

            node = nodeNextNext;
            newNode = newNodeNextNext;
        }

        return newHead;
    }
}
