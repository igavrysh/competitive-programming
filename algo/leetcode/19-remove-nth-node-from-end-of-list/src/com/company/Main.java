package com.company;

public class Main {

  private static void test1() {
    ListNode input = new ListNode(
        1,
        new ListNode(
            2,
            new ListNode(
                3,
                new ListNode(
                    4,
                    new ListNode(
                        5
                    )
                )
            )
        )
    );
    Solution s = new Solution();
    ListNode output = s.removeNthFromEnd(input, 2);
    boolean passed = output.val == 1
        && output.next.val == 2
        && output.next.next.val == 3
        && output.next.next.next.val == 5
        && output.next.next.next.next == null;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  private static void test2() {
    ListNode input = new ListNode(
        1,
        new ListNode(
            2,
            new ListNode(
                3,
                new ListNode(
                    4,
                    new ListNode(
                        5
                    )
                )
            )
        )
    );
    Solution s = new Solution();
    ListNode output = s.removeNthFromEnd(input, 1);
    boolean passed = output.val == 1
        && output.next.val == 2
        && output.next.next.val == 3
        && output.next.next.next.val == 4
        && output.next.next.next.next == null;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  private static void test3() {
    ListNode input = new ListNode(
        1,
        new ListNode(
            2,
            new ListNode(
                3,
                new ListNode(
                    4,
                    new ListNode(
                        5
                    )
                )
            )
        )
    );
    Solution s = new Solution();
    ListNode output = s.removeNthFromEnd(input, 5);
    boolean passed = output.val == 2
        && output.next.val == 3
        && output.next.next.val == 4
        && output.next.next.next.val == 5
        && output.next.next.next.next == null;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  private static void test4() {
    ListNode input = new ListNode(
        1,
        new ListNode(
            2
        )
    );
    Solution s = new Solution();
    ListNode output = s.removeNthFromEnd(input, 1);
    boolean passed = output.val == 1
        && output.next == null;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    //test2();
    //test3();
    //test4();
  }
}
