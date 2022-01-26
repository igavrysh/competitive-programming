package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void test1() {
    TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(4));
    TreeNode root2 = new TreeNode(1, new TreeNode(0), new TreeNode(3));
    Solution s = new Solution();
    List<Integer> output = s.getAllElements(root1, root2);
    boolean passed = Arrays.deepEquals(output.toArray(), new Integer[]{0,1,1,2,3,4});
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
  }
}
