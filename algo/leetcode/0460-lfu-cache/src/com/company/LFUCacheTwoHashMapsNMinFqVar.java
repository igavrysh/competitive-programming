package com.company;

import java.util.HashMap;

public class LFUCacheTwoHashMapsNMinFqVar {
    public HashMap<Integer, DLinkedList> fq;
    public HashMap<Integer, Node> nodes;
    public int capacity;
    public int currSize;
    public int minFQ;

    public LFUCacheTwoHashMapsNMinFqVar(int capacity) {
        this.capacity = capacity;
        currSize = 0;
        minFQ = -1;
        nodes = new HashMap<>();
        fq = new HashMap<>();
    }

    public int get(int key) {
        if (nodes.get(key) == null) {
            return -1;
        }
        Node node = nodes.get(key);
        return setAndGet(key, node.value);
    }

    private int setAndGet(int key, int value) {
        if (nodes.get(key) == null) {
            return -1;
        }
        Node node = nodes.get(key);
        node.value = value;
        DLinkedList l = fq.get(node.useCounter);
        fq.get(node.useCounter).remove(node);
        if (l.getSize() == 0) {
            fq.remove(node.useCounter);
            if (node.useCounter == minFQ) {
                minFQ++;
            }
        }
        node.useCounter++;
        DLinkedList newL = fq.getOrDefault(node.useCounter, new DLinkedList());
        fq.put(node.useCounter, newL);
        newL.addFirst(node);
        return node.value;
    }

    // removeLeastUsed removes least used element without updating minFq variable
    private Node removeLeastUsed() {
        if (currSize == 0) {
            return null;
        }
        DLinkedList l = fq.get(minFQ);
        Node node = l.removeLast();
        if (l.getSize() == 0) {
            fq.remove(minFQ);
        }
        currSize--;
        return node;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (nodes.get(key) != null) {
            setAndGet(key, value);
            return;
        }
        Node node = new Node(key, value);
        node.useCounter = 1;
        nodes.put(key, node);

        if (currSize == capacity) {
            Node removedNode = removeLeastUsed();
            nodes.remove(removedNode.key);
        }

        DLinkedList l = fq.getOrDefault(1, new DLinkedList());
        l.addFirst(node);
        fq.put(1, l);
        minFQ = 1;
        currSize++;
    }

    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        int useCounter = 0;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            useCounter = 1;
        }
    }

    class DLinkedList {
        Node sentinel;
        int size;

        public DLinkedList() {
            sentinel = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
            size = 0;
        }

        public int getSize() {
            return size;
        }

        public void addFirst(Node node) {
            Node sentinelNext = sentinel.next;
            sentinel.next = node;
            node.prev = sentinel;
            node.next = sentinelNext;
            sentinelNext.prev = node;
            size++;
        }

        public void remove(Node node) {
            Node nodePrev = node.prev;
            Node nodeNext = node.next;
            nodePrev.next = nodeNext;
            nodeNext.prev = nodePrev;
            size--;
        }

        public Node removeLast() {
            if (size == 0) {
                return null;
            }
            Node node = sentinel.prev;
            node.prev.next = sentinel;
            sentinel.prev = node.prev;
            size--;
            node.next = null;
            node.prev = null;
            return node;
        }
    }
}
