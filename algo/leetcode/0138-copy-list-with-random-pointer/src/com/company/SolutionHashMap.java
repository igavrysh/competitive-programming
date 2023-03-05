package com.company;

import java.util.HashMap;

public class SolutionHashMap {
    public Node copyRandomList(Node head) {
        // oldNode, newNode
        HashMap<Node, Node> M = new HashMap<>();
        
        Node sent = new Node(0);
        sent.next = head;

        Node newSent = new Node(0);
        Node node = head;
        Node newNode = null;
        Node prevNewNode = newSent;
        while (node != null) {
            newNode = new Node(node.val);
            prevNewNode.next = newNode; 
            M.put(node, newNode);
            node = node.next;
            prevNewNode = newNode;
        }

        node = sent;
        newNode = newSent;
        while (node != null) {
            Node random = node.random;
            if (random != null) {
                newNode.random = M.get(random);
            }
            node = node.next;
            newNode = newNode.next;
        }

        return newSent.next;
    }
}