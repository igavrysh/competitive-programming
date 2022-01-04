package com.company;

public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode proxy = new ListNode();
    proxy.next = head;
    ListNode current = proxy;
    ListNode next = head;
    while (current != null) {
      if (current != proxy && next != null && current.val == next.val) {
        next = next.next;
        continue;
      } else {
        current.next = next;
        current = next;
        if (next != null) {
          next = next.next;
        }
      }
    }
    return proxy.next;
  }
}
