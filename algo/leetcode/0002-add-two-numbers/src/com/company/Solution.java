package com.company;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ln1 = l1;
        ListNode ln2 = l2;
        ListNode resultLN = null;
        ListNode currentLN = null;
        while (ln1 != null || ln2 != null || carry != 0) {
            int val1 = ln1 == null ? 0 : ln1.val;
            int val2 = ln2 == null ? 0 : ln2.val;
            int result = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;

            if (currentLN == null) {
                currentLN = new ListNode(result);
                resultLN = currentLN;
            } else {
                currentLN.next = new ListNode(result);
                currentLN = currentLN.next;
            }

            if (ln1 != null) {
                ln1 = ln1.next;
            }

            if (ln2 != null) {
                ln2 = ln2.next;
            }
        }
        return resultLN;
    }
}
