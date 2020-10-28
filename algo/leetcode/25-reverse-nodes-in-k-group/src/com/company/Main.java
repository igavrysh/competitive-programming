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
                        5
                    )
                )
            )
        )
    );
    SolutionStack s = new SolutionStack();
    ListNode output = s.reverseKGroup(input, 2);
    boolean passed = output.val == 2
        && output.next.val == 1
        && output.next.next.val == 4
        && output.next.next.next.val == 3
        && output.next.next.next.next.val == 5
        && output.next.next.next.next.next == null;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
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
    SolutionStack s = new SolutionStack();
    ListNode output = s.reverseKGroup(input, 3);
    boolean passed = output.val == 3
        && output.next.val == 2
        && output.next.next.val == 1
        && output.next.next.next.val == 4
        && output.next.next.next.next.val == 5
        && output.next.next.next.next.next == null;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
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
    SolutionStack s = new SolutionStack();
    ListNode output = s.reverseKGroup(input, 1);
    boolean passed = output.val == 1
        && output.next.val == 2
        && output.next.next.val == 3
        && output.next.next.next.val == 4
        && output.next.next.next.next.val == 5
        && output.next.next.next.next.next == null;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    ListNode input = new ListNode(1);
    SolutionStack s = new SolutionStack();
    ListNode output = s.reverseKGroup(input, 1);
    boolean passed = output.val == 1
        && output.next == null;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }


  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
