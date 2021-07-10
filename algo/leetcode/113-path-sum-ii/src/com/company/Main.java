package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void test1() {
    TreeNode tn = new TreeNode(
        5,
        new TreeNode(
            4,
            new TreeNode(
                11,
                new TreeNode(7),
                new TreeNode(2)
            ),
            null
        ),
        new TreeNode(
            8,
            new TreeNode(13),
            new TreeNode(
                4,
                new TreeNode(5),
                new TreeNode(1))
        )
    );
    int targetSum = 22;
    Solution s = new Solution();
    List<List<Integer>> output = s.pathSum(tn, targetSum);
    boolean passed = output.size() == 2
        && output.stream()
        .map(path -> Arrays.equals(path.toArray(), new Integer[] {5, 4, 11, 2})
          || Arrays.equals(path.toArray(), new Integer[] {5, 8, 4, 5}))
        .reduce((e1, e2) -> e1 && e2)
        .orElse(false);
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    TreeNode tn = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    int targetSum =5;
    Solution s = new Solution();
    List<List<Integer>> output = s.pathSum(tn, targetSum);
    boolean passed = output.size() == 0;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    TreeNode tn = new TreeNode(1, new TreeNode(2), null);
    int targetSum = 0;
    Solution s = new Solution();
    List<List<Integer>> output = s.pathSum(tn, targetSum);
    boolean passed = output.size() == 0;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
