package com.company;

public class SolutionIterative {
  public ListNode reverseList(ListNode head) {
    ListNode current = head;
    ListNode previous = null;
    while (current != null) {
      ListNode currentNextTmp = current.next;
      current.next = previous;
      previous = current;
      current = currentNextTmp;
    }
    return previous;
  }
}

