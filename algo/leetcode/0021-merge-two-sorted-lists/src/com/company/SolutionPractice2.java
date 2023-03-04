package com.company;

public class SolutionPractice2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l = new ListNode();
        ListNode n = l;
        while (list1 != null || list2 != null) {
            ListNode next = null;
            if ((list1 != null && list2 != null && list1.val <= list2.val) || list2 == null) {
                next = list1;
                list1 = list1.next;
            } else if ((list1 != null && list2 != null && list1.val > list2.val) || list1 == null)  {
                next = list2;
                list2 = list2.next;
            }
            n.next = next;
            n = n.next;
        }
        return l.next;
    }
}
