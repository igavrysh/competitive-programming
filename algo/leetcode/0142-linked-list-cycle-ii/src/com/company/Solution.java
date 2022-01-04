package com.company;

import java.util.HashSet;
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
  }
}
