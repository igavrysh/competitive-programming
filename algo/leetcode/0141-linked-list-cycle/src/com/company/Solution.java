package com.company;

public class Solution {
  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    ListNode t = head;
    ListNode h = head.next;
    while (h != null && t != null) {
      if (t == h) {
        return true;
      }
      t = t.next;
      h = h.next;
      if (h != null) {
        h = h.next;
      }
    }
    return false;
  }
}
