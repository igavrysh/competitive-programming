package com.company;

public class Main {

  public static void test1() {

    ListNode cycle = new ListNode(
        2,
        new ListNode(0)
    );
    ListNode lastElement = new ListNode(
        -4,
        cycle);
    cycle.next.next = lastElement;
    ListNode input = new ListNode(
        3,
        cycle
    );
    SolutionO1Memory s = new SolutionO1Memory();
    ListNode output = s.detectCycle(input);
    boolean passed = output == cycle;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    ListNode input = null;
    SolutionO1Memory s = new SolutionO1Memory();
    ListNode output = s.detectCycle(input);
    boolean passed = output == null;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    ListNode input = new ListNode(1);
    SolutionO1Memory s = new SolutionO1Memory();
    ListNode output = s.detectCycle(input);
    boolean passed = output == null;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }


  public static void test4() {
    ListNode input = new ListNode(1, new ListNode(2));
    SolutionO1Memory s = new SolutionO1Memory();
    ListNode output = s.detectCycle(input);
    boolean passed = output == null;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }


  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
