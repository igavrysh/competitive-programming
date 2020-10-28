package com.company;

public class Solution {
  public ListNode swapPairs(ListNode head) {
    ListNode proxyHead = new ListNode();
    proxyHead.next = head;

    ListNode prev = proxyHead;
    ListNode current = proxyHead.next;
    ListNode next = proxyHead.next != null ? proxyHead.next.next : null;
    while (current != null && next != null) {
      current.next = next.next;
      prev.next = next;
      next.next = current;

      prev = current;
      current = current.next;
      next = current != null ? current.next : null;
    }
    return proxyHead.next;
  }
}
