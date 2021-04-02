package leetcode.solutions;

public class Solution {
  public ListNode addTwoNumbers(ListNode l1,
                                ListNode l2)
  {
    int carry = 0;
    ListNode resN = new ListNode(0);
    ListNode currN = resN;
    while (l1 != null || l2 != null || carry != 0) {
      int acc = (l1 == null ? 0 : l1.val)
          + (l2 == null ? 0 : l2.val)
          + carry;
      carry = acc / 10;
      currN.next = new ListNode(acc % 10);
      currN = currN.next;
      l1 = l1 != null ? l1.next : null;
      l2 = l2 != null ? l2.next : null;
    }
    return resN.next;
  }
}
//--------------------------------------------------