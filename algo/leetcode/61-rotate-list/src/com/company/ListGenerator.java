package com.company;

public class ListGenerator {

  static ListNode arrayToList(Integer[] array) {
    if (array.length == 0) {
      return null;
    }
    int idx = 0;
    ListNode output = new ListNode(array[idx++]);
    ListNode currNode = output;
    while (idx < array.length) {
      ListNode nextNode = new ListNode(array[idx++]);
      currNode.next = nextNode;
      currNode = nextNode;
    }
    return output;
  }
}
