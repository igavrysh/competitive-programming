package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    ListNode output = s.mergeKLists(new ListNode[] {
        new ListNode(
            1,
            new ListNode(
                4,
                new ListNode(5)
            )),
        new ListNode(
            1,
            new ListNode(
                3,
                new ListNode(4)
            )
        ),
        new ListNode(
            2,
            new ListNode(6)
        )
    });
    boolean passed = output != null
        && output.val == 1
        && output.next.val == 1
        && output.next.next.val == 2
        && output.next.next.next.val == 3
        && output.next.next.next.next.val == 4
        && output.next.next.next.next.next.val == 4
        && output.next.next.next.next.next.next.val == 5
        && output.next.next.next.next.next.next.next.val == 6
        && output.next.next.next.next.next.next.next.next == null;

    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
