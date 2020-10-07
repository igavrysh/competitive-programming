package com.company;

public class Main {

  public static void test1() {
    TreeNode input = new TreeNode(
        3,
        new TreeNode(9),
        new TreeNode(20,
            new TreeNode(15),
            new TreeNode(7)
        )
    );
    SolutionRecursive s = new SolutionRecursive();
    int output = s.maxDepth(input);
    boolean passed = output == 3;
    System.out.println("test1:" + (passed ? "passed" : "failed") );
  }

  public static void test2() {
    TreeNode input = new TreeNode(
        3,
        new TreeNode(9),
        new TreeNode(20,
            new TreeNode(15),
            new TreeNode(7)
        )
    );
    SolutionIterative s = new SolutionIterative();
    int output = s.maxDepth(input);
    boolean passed = output == 3;
    System.out.println("test2:" + (passed ? "passed" : "failed") );
  }

  public static void test3() {
    SolutionIterative s = new SolutionIterative();
    int output = s.maxDepth(null);
    boolean passed = output == 0;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
