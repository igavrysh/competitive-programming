package com.company;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public ListNode detectCycle(ListNode head) {
    Set<ListNode> path = new HashSet<>();
    ListNode current = head;
    while (current != null && !path.contains(current)) {
      path.add(current);
      current = current.next;
    }
    return current;

    /*
    while (fast != slow || fast.next == null || slow.next == null) {
      fast = fast.next;

      slow = slow.next;

      if (fast != slow) {
        fast = fast.next;

      }
    }

    if (fast != slow) {
      return null;
    }

    ListNode node = head;
    while


    ListNode prevN = null;
    while (fast == slow) {


      ListNode output = head;
      int i = 0;
      while (i < position) {
        output = output.next;
        i++;
      }
      return  output;
    }
    return null;
*/
  }
}
