package com.company;

public class Solution {
  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode proxyHead = new ListNode(0, head);
    int i = -1;
    ListNode prevStart = null;
    ListNode startN = null;
    ListNode endN = null;
    ListNode c = proxyHead;
    ListNode n = c.next;
    ListNode nn = c.next.next;
    while (c != null && i <= right-1) {
      if (i == left-2) {
        prevStart = c;
      }
      if (i == left-1) {
        startN = c;
      }
      if (i == right-1) {
        endN = c;
      }
      ListNode tmp = nn != null ? nn.next : null;
      if (i >= left-1 && i < right-1) {
        n.next = c;
      }
      c = n;
      n = nn;
      nn = tmp;
      i++;
    }
    prevStart.next = endN;
    startN.next = c;
    return proxyHead.next;
  }
}
