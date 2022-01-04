package com.company;

public class SolutionMergeDivNConq {

  public ListNode mergeKLists(ListNode[] lists) {
    ListNode output = null;

    if (lists.length == 0) {
      return null;
    }

    int currentSize = lists.length;

    while (currentSize > 1) {
      for (int i = 0; i < currentSize / 2; i++) {
        lists[i] = mergeTwoLists(lists[i * 2], lists[i * 2 + 1]);
      }
      if (currentSize % 2 != 0) {
        lists[currentSize / 2]  = lists[currentSize - 1];
      }

      if (currentSize % 2 == 0) {
        currentSize = currentSize / 2;
      } else {
        currentSize = (currentSize / 2) + 1;
      }
    }
    return lists[0];
  }

  private ListNode mergeTwoLists(ListNode n1, ListNode n2) {
    ListNode output = null;
    ListNode cursor = null;
    while (n1 != null || n2 != null) {
      ListNode next = null;
      if (n1 != null && n2 != null) {
        if (n1.val < n2.val) {
          next = n1;
          n1 = n1.next;
        } else {
          next = n2;
          n2 = n2.next;
        }
      } else if (n1 == null && n2 != null) {
        next = n2;
        n2 = n2.next;
      } else if (n1 != null && n2 == null) {
        next = n1;
        n1 = n1.next;
      }

      if (cursor == null) {
        output = next;
        cursor = next;
      } else {
        cursor.next = next;
        cursor = next;
      }
    }
    return output;
  }
}
