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
                    4
                )
            )
        )
    );
    Solution s = new Solution();
    ListNode output = s.swapPairs(input);
    boolean passed = output.val == 2
        && output.next.val == 1
        && output.next.next.val == 4
        && output.next.next.next.val == 3
        && output.next.next.next.next == null;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    ListNode input = null;
    Solution s = new Solution();
    ListNode output = s.swapPairs(input);
    boolean passed = output == null;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    ListNode input = new ListNode(1);
    Solution s = new Solution();
    ListNode output = s.swapPairs(input);
    boolean passed = output.val == 1;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
