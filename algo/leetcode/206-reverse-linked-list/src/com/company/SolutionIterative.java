package com.company;

public class SolutionIterative {
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode newHead = null;
    ListNode current = head.next;
    ListNode previous = head;

    if (current == null) {
      return previous;
    }

    while (current != null) {
      if (current.next == null) {
        newHead = current;
      }
      if (previous == head) {
        previous.next = null;
      }

      ListNode currentNextTmp = current.next;

      current.next = previous;
      previous = current;
      current = currentNextTmp;
    }
    return newHead;
  }
}

