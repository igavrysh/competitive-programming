package com.company;

public class Main {

  public static void test1() {
    String input = "3*4-2*5";
    Solution s = new Solution();
    Node output = s.expTree(input);
    boolean passed = output.val == '-'
        && output.left.val == '*'
        && output.right.val == '*'
        && output.left.left.val == '3'
        && output.left.right.val == '4'
        && output.right.left.val == '2'
        && output.right.right.val == '5';
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    String input = "2-3/(5*2)+1";
    Solution s = new Solution();
    Node output = s.expTree(input);
    boolean passed = output.val == '+'
        && output.left.val == '-'
        && output.right.val == '1'
        && output.left.left.val == '2'
        && output.left.right.val == '/'
        && output.left.right.left.val == '3'
        && output.left.right.right.val == '*'
        && output.left.right.right.left.val == '5'
        && output.left.right.right.right.val == '2';
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
