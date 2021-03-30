package com.company;

public class Main {

  public static void test1() {
    Node input = new Node(
        1,
        new Node(
            2,
            new Node(4, null, null, null),
            new Node(5, null, null, null),
            null),
        new Node(
            3,
            new Node(6, null, null, null),
            new Node(7, null, null, null),
            null),
        null);
    Solution s = new Solution();
    Node output = s.connect(input);
    boolean passed =
        output.next == null
        && output.left.next.val == 3
        && output.right.next == null
        && output.left.left.next.val == 5
        && output.left.right.next.val == 6
        && output.right.left.next.val == 7
        && output.right.right.next == null;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
