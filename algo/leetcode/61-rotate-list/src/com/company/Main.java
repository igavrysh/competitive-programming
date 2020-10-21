package com.company;

public class Main {

  public static void test1() {
    ListNode input = ListGenerator.arrayToList(new Integer[] {1, 2, 3, 4, 5});
    Solution s = new Solution();
    ListNode output = s.rotateRight(input, 2);
    boolean passed = output.val == 4
        && output.next.val == 5
        && output.next.next.val == 1
        && output.next.next.next.val == 2
        && output.next.next.next.next.val == 3
        && output.next.next.next.next.next == null;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    ListNode input = ListGenerator.arrayToList(new Integer[] {0, 1, 2});
    Solution s = new Solution();
    ListNode output = s.rotateRight(input, 4);
    boolean passed = output.val == 2
        && output.next.val == 0
        && output.next.next.val == 1
        && output.next.next.next == null;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    ListNode input = ListGenerator.arrayToList(new Integer[] {});
    Solution s = new Solution();
    ListNode output = s.rotateRight(input, 0);
    boolean passed = output == null;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    ListNode input = ListGenerator.arrayToList(new Integer[] {1});
    Solution s = new Solution();
    ListNode output = s.rotateRight(input, 0);
    boolean passed = output.val == 1
        && output.next == null;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    ListNode input = ListGenerator.arrayToList(new Integer[] {1});
    Solution s = new Solution();
    ListNode output = s.rotateRight(input, 1);
    boolean passed = output.val == 1
        && output.next == null;
    System.out.println("test5:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
  }
}
