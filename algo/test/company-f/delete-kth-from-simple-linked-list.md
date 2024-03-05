```
// problem 1: delete the kth node from the end of a singly linked list
// 1 -> 2 -> 3 -> 4 -> 5 -> null, k = 2
// ouput: 1->2->3->5->null
```

```
import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  static class Node {
    public Node next;
    public int value;

    public Node(Node next, int value) {
      this.next = next;
      this.value = value;
    }
  }  
  
  public Node removeKth(Node head, int K) {
    if (K <= 0) {
      return head;
    }
    Node sentinel = new Node(head, -1);
    Node previous = sentinel;
    Node cursorDelete = sentinel.next;
    Node cursorEnd = sentinel.next;
    int counter = 0;
    while (counter < K-1) { 
      if (cursorEnd == null) {
        // list size < K
        return sentinel.next;
      }
      cursorEnd = cursorEnd.next;

      coutner++;
    }

    // counter = 1
    // cursorEnd = 2
    // sentiner = s
    // cursorDelete = 1
    // previous = s

    while (cursourEnd.next != null) {
      previous = cursorDelete;
      cursorDelete = cursorDelete.next;
      cursourEnd = cursourEnd.next;
    }
    previous.next = cursorDelete.next;

    return sentinel.next;
  }

}
```