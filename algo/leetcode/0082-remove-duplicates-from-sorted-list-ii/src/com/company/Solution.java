package com.company;

public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode proxy = new ListNode();
    proxy.next = head;
    ListNode outputHead = proxy;
    ListNode current = proxy;
    while (current != null) {
      ListNode next = current.next;
      int q = 1;
      while ((next != null && current.val == next.val) || current == proxy) {
        if (current != proxy) {
          q++;
        }
        current = next;
        next = next.next;
      }
      if (q == 1) {
        outputHead.next = current;
        outputHead = outputHead.next;
      } else {
        outputHead.next = null;
      }
      current = next;
    }
    return proxy.next;
  }
}
