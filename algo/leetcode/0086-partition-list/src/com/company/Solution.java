package com.company;

public class Solution {
  public ListNode partition(ListNode head, int x) {
    ListNode r = new ListNode(-1);
    ListNode l = new ListNode(-1);
    ListNode rHead = r;
    ListNode lHead = l;

    ListNode current = head;

    while (current != null) {

      if (current.val < x) {
        l.next = current;
        if (current != null) {
          l = current;
        }
      }

      if (current.val >= x) {
        r.next = current;
        if (current != null) {
          r = current;
        }
      }
      current = current.next;
    }

    l.next = rHead.next;
    r.next = null;
    return lHead.next;
  }
}
