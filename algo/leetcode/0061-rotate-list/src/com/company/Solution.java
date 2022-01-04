package com.company;

public class Solution {

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return null;
    }

    ListNode proxy = new ListNode(0);
    proxy.next = head;
    int N = 0;
    ListNode curr = head;
    while (curr != null) {
      N++;
      curr = curr.next;
    }
    int K = k % N;

    curr = proxy;
    int j = 0;
    while(j < K) {
      curr = curr.next;
      j++;
    }

    ListNode currHead = proxy;
    ListNode currTail = curr;

    while (currTail.next != null) {
      currHead = currHead.next;
      currTail = currTail.next;
    }

    if (currHead.next != null) {
      proxy.next = currHead.next;
      currHead.next = null;
      currTail.next = head;
    }

    return proxy.next;
  }

}
