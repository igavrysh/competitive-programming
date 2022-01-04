package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

  private static void test1() {
    TreeNode input = new TreeNode(
        3,
        new TreeNode(9),
        new TreeNode(
            20,
            new TreeNode(15),
            new TreeNode(7)
        )
    );
    Solution s = new Solution();
    List<List<Integer>> output = s.levelOrderBottom(input);
    boolean passed = output.size() == 3
        && output.get(0).equals(Arrays.asList(new int[] {15, 7}))
        && output.get(1).equals(Arrays.asList(new int[] {9, 20}))
        && output.get(2).equals(Arrays.asList(new int[] {3}));
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
