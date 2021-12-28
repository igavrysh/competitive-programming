package com.company;

import java.util.HashMap;

public class LFUCache {

  class Node {
    int key;
    int value;
    Node next;
    Node prev;
    int useCounter = 0;

    boolean isHead;
    boolean isTail;
  }

  public Node head;
  public Node tail;
  public HashMap<Integer, Node> dict;
  public int k;

  public LFUCache(int capacity) {
    k = capacity;
    dict = new HashMap<>();
  }

  public  int get(int key) {
    Node node = dict.get(key);
    if (node == null) {
      return -1;
    }

    node.useCounter++;
    place(node);
    return node.value;
  }

  public void put(int key, int value) {
    if (k == 0) {
      return;
    }

    Node node = dict.get(key);
    if (node != null) {
      node.useCounter++;
      node.value = value;
      place(node);
      return;
    }

    node = new Node();
    node.key = key;
    node.value = value;
    node.useCounter = 1;

    dict.put(key, node);
    if (dict.size() > k) {
      dict.remove(head.key);
      if (tail == head) {
        head = head.next;
        tail = head;
      } else {
        head = head.next;
        head.prev = null;
      }
    }

    if (head == null) {
      head = node;
      tail = node;
    } else {
      node.next = head;
      head.prev = node;
      head = node;
      place(node);
    }
  }

  private void place(Node node) {
    Node prev = node.prev;
    Node next = node.next;

    // No updates are needed
    if (next == null  || next.useCounter > node.useCounter) {
      return;
    }

    Node proxyHead = new Node();
    proxyHead.prev = null;
    proxyHead.next = head;
    head.prev = proxyHead;

    Node proxyTail = new Node();
    proxyTail.next = null;
    proxyTail.prev = tail;
    tail.next = proxyTail;

    prev = node.prev;
    next = node.next;

    // eject node
    prev.next = next;
    next.prev = prev;

    // find a place for node
    while (next != proxyTail && next.useCounter <= node.useCounter) {
      prev = next;
      next = next.next;
    }

    // insert node in new place
    prev.next = node;
    node.prev = prev;
    node.next = next;
    next.prev = node;

    if (node.prev == proxyHead) {
      head = node;
    }

    if (node.next == proxyTail) {
      tail = node;
    }

    // recover invariant
    head = proxyHead.next;
    head.prev = null;
    tail = proxyTail.prev;
    tail.next = null;
  }
}
