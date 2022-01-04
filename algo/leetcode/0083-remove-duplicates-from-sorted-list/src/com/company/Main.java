package com.company;

public class Main {

  public static void test1() {
    ListNode input = new ListNode(1, new ListNode(2, new ListNode(2)));
    Solution s = new Solution();
    ListNode output = s.deleteDuplicates(input);
    boolean passed = output.val == 1 && output.next.val == 2 && output.next.next == null;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    ListNode input = new ListNode(1,
        new ListNode(1,
            new ListNode(2,
                new ListNode(3,
                    new ListNode(3)))));
    Solution s = new Solution();
    ListNode output = s.deleteDuplicates(input);
    boolean passed = output.val == 1 && output.next.val == 2 && output.next.next.val == 3
        && output.next.next.next == null;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    ListNode input = new ListNode(1, new ListNode(1));
    Solution s = new Solution();
    ListNode output = s.deleteDuplicates(input);
    boolean passed = output.val == 1 && output.next == null
        && output.next == null;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    ListNode input = null;
    Solution s = new Solution();
    ListNode output = s.deleteDuplicates(input);
    boolean passed = output == null;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
