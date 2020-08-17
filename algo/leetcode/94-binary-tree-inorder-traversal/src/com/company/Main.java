package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void test1() {
    TreeNode tree = new TreeNode(
        1,
        null,
        new TreeNode(
            2,
            new TreeNode(3),
            null));
    SolutionArrayRecreation solutionArrayRecreation = new SolutionArrayRecreation();
    List<Integer> output = solutionArrayRecreation.inorderTraversal(tree);
    Integer[] expectedResult = new Integer[]{1, 3, 2};
    boolean checked = Arrays.equals(output.toArray(), expectedResult);
    System.out.println(checked ? "test1 passed" : "test1 failed");
  }

  public static void test2() {
    TreeNode tree = new TreeNode(
        1,
        null,
        new TreeNode(
            2,
            new TreeNode(3),
            null));
    SolutionResultPassedAsArgument solution = new SolutionResultPassedAsArgument();
    List<Integer> output = solution.inorderTraversal(tree);
    Integer[] expectedResult = new Integer[]{1, 3, 2};
    boolean checked = Arrays.equals(output.toArray(), expectedResult);
    System.out.println(checked ? "test2 passed" : "test2 failed");
  }

  public static void testSolutionMorrisTraversal1() {
    TreeNode tree = new TreeNode(
        8,
        new TreeNode(
            4,
            new TreeNode(2),
            new TreeNode(6)
        ),
        new TreeNode(
            15,
            new TreeNode(12),
            new TreeNode(20)
        )
    );
    SolutionMorrisTraversal solution = new SolutionMorrisTraversal();
    List<Integer> output = solution.inorderTraversal(tree);
    Integer[] expectedResult = new Integer[]{2, 4, 6, 8, 12, 15, 20};
    boolean passed = Arrays.equals(output.toArray(), expectedResult);
    System.out.println("testSolutionMorrisTraversal1:"
        + (passed ? "passed" : " failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    testSolutionMorrisTraversal1();
  }
}
