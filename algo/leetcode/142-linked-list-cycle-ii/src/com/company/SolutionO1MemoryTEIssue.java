package com.company;

public class SolutionO1MemoryTEIssue {

  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }

    ListNode fast = head;
    ListNode slow = head;
    fast = head.next.next;
    slow = head.next;
    //while (fast != slow && fast != null && fast.next != null) {
    while (fast != slow && fast != null && fast.next != null) {
      if (fast == slow) {
        break;
      }
      fast = fast.next;
      slow = slow.next;
      if (fast != slow && fast != null && fast.next != null) {
        fast = fast.next;
      }

    }

    if (fast == null || slow == null || fast != slow) {
      return null;
    }

    ListNode current = head;

    while (fast != current) {
      fast = fast.next;
      current = current.next;
    }
    return fast;
  }
}
