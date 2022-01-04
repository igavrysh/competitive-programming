package com.company;

public class SolutionO1Space {

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prevTail = dummy;

    while (prevTail != null && prevTail.next != null) {
      ListNode currentHead = prevTail.next;

      ListNode current = currentHead;
      int count = 1;
      while (current != null && count < k) {
        current = current.next;
        count++;
      }

      if (current != null) {
        ListNode currentTail = current;
        ListNode tailNext = current.next;

        reverseList(currentHead, currentTail);

        prevTail.next = currentTail;
        currentHead.next = tailNext;

        prevTail = currentHead;
      } else {
        prevTail = null;
      }
    }
    return dummy.next;
  }

  public void reverseList(ListNode head, ListNode tail) {
    ListNode current = head;
    ListNode next = current.next;
    while(current != tail) {
      ListNode nextNext = next.next;
      next.next = current;
      current = next;
      next = nextNext;
    }
  }
}
