package com.company;

public class Main {

  public static ListNode listFromArray(int[] arr) {
    ListNode proxy = new ListNode(-1);
    ListNode current = proxy;
    for (int i = 0; i < arr.length; i++) {
      ListNode n = new ListNode(arr[i]);
      current.next = n;
      current = current.next;
    }
    return proxy.next;
  }

  public static ListNode[] cycledListFromArray(int[] arr, int i) {
    ListNode list = listFromArray(arr);
    ListNode current = list;
    int counter = 1;
    ListNode cycleNode = null;
    while (current.next != null) {
      if (counter == i) {
        cycleNode = current;
      }
      current = current.next;
    }
    if (cycleNode != null) {
      current.next = cycleNode;
    }
    return new ListNode[] {list, cycleNode};
  }

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
    SolutionO1MemoryTEIssue s = new SolutionO1MemoryTEIssue();
    ListNode output = s.detectCycle(input);
    boolean passed = output == cycle;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    ListNode input = null;
    SolutionO1MemoryTEIssue s = new SolutionO1MemoryTEIssue();
    ListNode output = s.detectCycle(input);
    boolean passed = output == null;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    ListNode input = new ListNode(1);
    SolutionO1MemoryTEIssue s = new SolutionO1MemoryTEIssue();
    ListNode output = s.detectCycle(input);
    boolean passed = output == null;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }


  public static void test4() {
    ListNode input = new ListNode(1, new ListNode(2));
    SolutionO1MemoryTEIssue s = new SolutionO1MemoryTEIssue();
    ListNode output = s.detectCycle(input);
    boolean passed = output == null;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    ListNode[] input = cycledListFromArray(
        new int[] {
            -21,10,17,8,4,
            26,5,35,33,-7,
            -16,27,-12,6,29,
            -12,5,9,20,14,
            14,2,13,-24,21,
            23,-21,5
        },
        24);
    ListNode head = input[0];
    ListNode cycle = input[1];
    SolutionO1MemoryTEIssue s = new SolutionO1MemoryTEIssue();
    ListNode output = s.detectCycle(head);
    boolean passed = output == cycle;
    System.out.println("test5:" + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    int[] inputArr = new int[] {
        -21,10,17,8,4,
        26,5,35,33,-7,
        -16,27,-12,6,29,
        -12,5,9,20,14,
        14,2,13,-24,21,
        23,-21,5
    };

    for (int i = 1; i < inputArr.length; i++) {
      System.out.println("test6(" +  i + "):");
      ListNode[] input = cycledListFromArray(inputArr, i);
      ListNode head = input[0];
      ListNode cycle = input[1];
      SolutionO1MemoryTEIssue s = new SolutionO1MemoryTEIssue();
      ListNode output = s.detectCycle(head);
      boolean passed = output == cycle;
      System.out.println(passed ? "passed" : "failed");
    }


  }



  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
  }
}
