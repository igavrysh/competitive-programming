package com.company;

public class Main {

  public static void test1() {
    TreeNode t = new TreeNode(
        2,
        new TreeNode(1),
        new TreeNode(3)
    );
    SolutionOptimized s = new SolutionOptimized();
    int output = s.findBottomLeftValue(t);
    boolean passed = output == 1;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    TreeNode t = new TreeNode(
        1,
        new TreeNode(
            2,
            new TreeNode(4),
            null
        ),
        new TreeNode(
            3,
            new TreeNode(
                5,
                new TreeNode(7),
                null
            ),
            new TreeNode(6)
        )
    );
    SolutionOptimized s = new SolutionOptimized();
    int output = s.findBottomLeftValue(t);
    boolean passed = output == 7;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
