package com.company;

public class SolutionCompareOne2One {

  public ListNode mergeKLists(ListNode[] lists) {
    ListNode output = null;
    ListNode current = null;

    boolean changed = true;

    while (changed) {
      changed = false;

      Long min = Long.MAX_VALUE;
      int minI = -1;
      for (int i = 0; i < lists.length; i++) {
        if (lists[i] != null && min > lists[i].val) {
          min = Long.valueOf(lists[i].val);
          minI = i;
        }
      }

      if (min != Long.MAX_VALUE) {
        if (minI != -1) {
          if (current != null) {
            current.next = new ListNode(lists[minI].val);
            current = current.next;
          } else  {
            current = new ListNode(lists[minI].val);;
            output = current;
          }
          changed = true;
          lists[minI] = lists[minI].next;
        }
      }
    }
    return output;
  }
}
