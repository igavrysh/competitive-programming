package com.company;

import java.util.HashMap;

class Node {
  Node next;
  Node prev;
  int key;
  int value;
}

class LRUCache {
  int capacity;
  Node head;
  Node tail;

  HashMap<Integer, Node> KV = new HashMap<>();

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (KV.containsKey(key)) {
      Node node = KV.get(key);
      this.put(key, node.value);
      return node.value;
    }
    return -1;
  }

  public void put(int key, int value) {
    Node node = new Node();
    node.key = key;
    node.value = value;
    // Deque
    if (KV.containsKey(key)) {
      node = KV.get(key);
      node.value = value;
      Node prevNode = node.prev;
      Node nextNode = node.next;
      if (nextNode != null) {
        nextNode.prev = prevNode;
      } else {
        tail = prevNode;
      }
      if (prevNode != null) {
        prevNode.next = nextNode;
      } else {
        head = nextNode;
      }
    }

    // Enque
    node.next = head;
    node.prev = null;
    if (node.next != null) {
      node.next.prev = node;
    }
    head = node;
    KV.put(node.key, node);
    if (KV.size() == 1) {
      tail = head;
    }

    // Cut the tail
    if (KV.size() > capacity) {
      if (tail != null) {
        KV.remove(tail.key);
        tail = tail.prev;
        if (tail != null) {
          tail.next = null;
        }
      }
    }
  }
}