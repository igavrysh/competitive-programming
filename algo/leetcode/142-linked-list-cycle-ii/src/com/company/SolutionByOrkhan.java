package com.company;

public class SolutionByOrkhan {
  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }

    ListNode slow = head;
    ListNode fast = head;
    slow = slow.next;
    fast = fast.next.next;

    while (fast != null && fast.next != null) {
      if (slow == fast) {
        break;
      }
      slow = slow.next;
      fast = fast.next.next;
    }

    if (slow == fast) {
      slow = head;
      while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
      }
      return slow;
    }
    return null;
  }
}
