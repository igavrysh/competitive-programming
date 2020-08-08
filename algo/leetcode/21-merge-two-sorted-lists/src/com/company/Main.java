package com.company;

public class Main {

    public static void test1() {
        Solution solution = new Solution();

        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode( 4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode( 4)));
        ListNode output = solution.mergeTwoLists(l1, l2);
        boolean checked = output.val == 1
                && output.next.val == 1
                && output.next.next.val == 2
                && output.next.next.next.val == 3
                && output.next.next.next.next.val == 4
                && output.next.next.next.next.next.val == 4;
        System.out.println(checked ? "test1 passed" : "test2 failed");
    }

    public static void main(String[] args) {
        test1();
    }
}
