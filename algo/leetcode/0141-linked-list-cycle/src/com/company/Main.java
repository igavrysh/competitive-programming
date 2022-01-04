package com.company;

public class Main {

  private static void test1() {
    ListNode l1 = new ListNode(3);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(0);
    ListNode l4 = new ListNode(-4);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l2;
    Solution s = new Solution();
    boolean output = s.hasCycle(l1);
    boolean passed = output == true;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
