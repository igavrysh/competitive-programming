package leetcode.solutions;

public class Solution2 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode resN = new ListNode(0);
    int carry = 0;
    ListNode currN = resN;
    while (l1 != null || l2 != null || carry != 0) {
      currN.next = new ListNode(carry +
          (l1 == null ? 0 : l1.val)
          + (l2 == null ? 0 : l2.val));
      currN = currN.next;
      carry = currN.val / 10;
      currN.val = currN.val % 10;
      if (l1 != null) l1 = l1.next;
      if (l2 != null) l2 = l2.next;
    }
    return resN.next;
  }
}
//--------------------------------------------------