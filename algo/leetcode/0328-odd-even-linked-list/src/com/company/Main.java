package com.company;

import java.util.List;

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
                      new ListNode(5)))));
      Solution solution = new Solution();
      ListNode output = solution.oddEvenList(input);
      boolean checked = output.val == 1
          && output.next.val == 3
          && output.next.next.val == 5
          && output.next.next.next.val == 2
          && output.next.next.next.next.val == 4
          && output.next.next.next.next.next == null;

      System.out.println("test1:" + (checked ? "passed" : "failed"));
  }

  public static void test2() {
    ListNode input = new ListNode(
        2,
        new ListNode(
            1,
            new ListNode(
                3,
                new ListNode(
                    5,
                    new ListNode(
                        6,
                        new ListNode(
                            4,
                            new ListNode(7)))))));
    Solution solution = new Solution();
    ListNode output = solution.oddEvenList(input);
    boolean checked = output.val == 2
        && output.next.val == 3
        && output.next.next.val == 6
        && output.next.next.next.val == 7
        && output.next.next.next.next.val == 1
        && output.next.next.next.next.next.val == 5
        && output.next.next.next.next.next.next.val == 4
        && output.next.next.next.next.next.next.next == null;

    System.out.println("test2:" + (checked ? "passed" : "failed"));
  }

  public static void test3() {
    ListNode input = new ListNode(2);
    Solution solution = new Solution();
    ListNode output = solution.oddEvenList(input);
    boolean checked = output.val == 2
        && output.next == null;
    System.out.println("test3:" + (checked ? "passed" : "failed"));
  }

  public static void test4() {
    Solution solution = new Solution();
    ListNode output = solution.oddEvenList(null);
    boolean checked = output == null;
    System.out.println("test4:" + (checked ? "passed" : "failed"));
  }

  public static void test5() {
    ListNode input = new ListNode(1, new ListNode(2));
    Solution solution = new Solution();
    ListNode output = solution.oddEvenList(input);
    boolean checked = output.val == 1
        && output.next.val == 2
        && output.next.next == null;
    System.out.println("test5:" + (checked ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
  }
}
