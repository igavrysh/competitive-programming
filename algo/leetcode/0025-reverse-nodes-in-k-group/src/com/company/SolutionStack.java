package com.company;

import java.util.Stack;

public class SolutionStack {

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode proxy = new ListNode();
    proxy.next = head;

    ListNode current = proxy.next;

    ListNode beforeHead = proxy;
    ListNode afterTail = null;
    while (current != null) {
      Stack<ListNode> S = new Stack<>();
      while (S.size() < k && current != null) {
        S.push(current);
        current = current.next;
      }

      afterTail = current;

      if (S.size() == k) {
        ListNode stackOpPrev = beforeHead;
        while (S.size() != 0) {
          ListNode node = S.pop();
          if (S.size() == 0) {
            beforeHead = node;
          }
          stackOpPrev.next = node;
          stackOpPrev = stackOpPrev.next;
        }
        stackOpPrev.next = afterTail;
      }
    }
    return proxy.next;
  }
}
