package com.company;

public class SolutionO1Memory {

  public ListNode detectCycle(ListNode head) {
    ListNode proxy = new ListNode(-1);
    proxy.next = head;
    if (proxy.next == null || proxy.next.next == null) {
      return null;
    }
    ListNode fast = proxy.next.next;
    ListNode slow = proxy.next;
    while (fast != slow && fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      //if (fast != slow && fast != null) {
      //  fast = fast.next;
     // }

    }

    if (fast == null || slow == null || fast != slow) {
      return null;
    }

    ListNode current = proxy;

    while (fast != current) {
      fast = fast.next;
      current = current.next;
    }
    return fast;
  }
}
