package com.company;

public class Main {

  public static void test1() {
    ListNode input = new ListNode(
        1,
        new ListNode(
            2,
            new ListNode(
                3,
                new ListNode(
                    4,
                    new ListNode(
                        5,
                        null
                    )
                )
            )
        )
    );
    Solution s = new Solution();
    ListNode output = s.reverseBetween(input, 2, 4);
    boolean passed = output.val == 1
        && output.next.val == 4
        && output.next.next.val == 3
        && output.next.next.next.val == 2
        && output.next.next.next.next.val == 5;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    ListNode input = new ListNode(
        5,
        null
    );
    Solution s = new Solution();
    ListNode output = s.reverseBetween(input, 1, 1);
    boolean passed = output.val == 5
        && output.next == null;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
