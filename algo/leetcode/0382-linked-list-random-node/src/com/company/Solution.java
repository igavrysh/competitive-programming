package com.company;

import java.util.Random;

public class Solution {

  private int size;
  private ListNode head;

  public Solution(ListNode head) {
    this.head = head;
    ListNode node = head;
    while (node != null) {
      size++;
      node = node.next;
    }
  }

  public int getRandom() {
    Random r = new Random();
    int j = r.nextInt(this.size);
    int i = 0;
    ListNode node = this.head;
    while (i != j) {
      node = node.next;
      i++;
    }
    return node.val;
  }
}
