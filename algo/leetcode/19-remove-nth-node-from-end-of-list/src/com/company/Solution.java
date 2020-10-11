package com.company;

public class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) {
      return head;
    }
    ListNode prevt = null;
    ListNode prevh = null;

    ListNode t = head;
    ListNode h = head;

    for (int i = 0; i < n; i++) {
      prevt = t;
      t = t.next;
    }

    while (t != null && t.next != null) {
      prevt = t;
      prevh = h;
      t = t.next;
      h = h.next;
    }

    if (h == head && h == t) {
      return head.next;
    }

    if (h.next != null) {
      h.next = h.next.next;
    }

    return head;
  }
}
