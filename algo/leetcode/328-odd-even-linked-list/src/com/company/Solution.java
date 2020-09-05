package com.company;

public class Solution {
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next ==  null) {
      return head;
    }
    ListNode oddNodeHead = head;
    ListNode oddNodeTail = head;
    ListNode evenNodeHead = head.next;
    ListNode evenNodeTail = head.next;

    int index = 2;

    ListNode currNode = evenNodeHead.next;

    while (currNode != null) {
      // even
      if ((index + 1) % 2 == 0) {
        evenNodeTail.next = currNode;
        evenNodeTail = evenNodeTail.next;
      } else {
        oddNodeTail.next = currNode;
        oddNodeTail = oddNodeTail.next;
      }
      index++;
      currNode = currNode.next;
    }
    oddNodeTail.next = evenNodeHead;
    evenNodeTail.next = null;
    return head;
  }
}
