package com.company;

import java.util.PriorityQueue;

public class MaxStack {
    class Node {
        public int val;
        public long time;
        public Node next;
        public Node prev;
        public Node(int val, long time) {
            this.val = val;
            this.time = time;
        }
    }

    private Node head;
    private long counter = 0;
    private PriorityQueue<Node> queue;

    // O(1)
    public MaxStack() {
        head = null;
        queue = new PriorityQueue<>((Node a, Node b) -> { 
            return a.val - b.val == 0 ? (a.time - b.time > 0 ? -1 : 1) : (a.val - b.val > 0 ? -1 : 1); 
        });
    }

    // O(logn)
    public void Push(int x) {
        Node n = new Node(x, counter++);
        if (head != null) {
            head.next = n;
            n.prev = head;
        }
        head = n;
        queue.offer(n);
    }

    // O(logn)
    public int Pop() {
        if (head == null) { throw new RuntimeException("cannot pop empty stack"); }
        queue.remove(head);
        Node currHead = head;
        head = head.prev;
        return currHead.val;
    }

    // O(1)
    public int Top() {
        if (head == null) { throw new RuntimeException("cannot top empty stack"); }
        return head == null ? -1 : head.val;
    }

    // O(logn)
    public int PeekMax() {
        if (head == null) { throw new RuntimeException("cannot peek empty stack"); }
        return queue.peek().val;
    }

    // O(logn)
    public int PopMax() {
        if (head == null) { throw new RuntimeException("cannot pop empty stack"); }
        Node n = queue.poll();
        Node sntnl = new Node(-1, 0);
        sntnl.prev = head;
        head.next = sntnl;
        // remove node from double-linked list
        Node nNext = n.next;
        Node nPrev = n.prev;
        if (nNext != null) {
            nNext.prev = nPrev;
        }
        if (nPrev != null) {
            nPrev.next = nNext;
        }
        // update head (in case head should be removed)
        head = sntnl.prev;
        if (head != null) {
            head.next = null;
        }
        return n.val;
    }
}
