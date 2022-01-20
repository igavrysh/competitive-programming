package com.company;

public class SolutionNew {

  public ListNode detectCycle(ListNode head) {
    if (head == null) { return null; }
    ListNode proxy = new ListNode(-1);
    proxy.next = head;
    ListNode fast = head.next, slow = head;
    while (fast != null && fast != slow) {
      slow = slow.next;
      fast = fast.next;
      if (fast != null) {
        fast = fast.next;
      }
    }
    if (fast == null) {
      return null;
    }

    slow = proxy;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return fast;
  }
}
