package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void test1() {
    TreeNode input = new TreeNode(
        1,
        new TreeNode(
            3,
            new TreeNode(5, null, null),
            new TreeNode(3, null, null)
        ),
        new TreeNode(
            2,
            null,
            new TreeNode(9, null, null)
        )
    );
    Solution s = new Solution();
    List<Integer> output = s.largestValues(input);
    boolean passed = Arrays.equals(output.toArray(), new Integer[] {1,3,9});
    System.out.println("tes1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    TreeNode input = new TreeNode(
        1,
        new TreeNode(2, null, null),
        new TreeNode(3, null, null)
    );
    Solution s = new Solution();
    List<Integer> output = s.largestValues(input);
    boolean passed = Arrays.equals(output.toArray(), new Integer[] {1,3});
    System.out.println("tes2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    TreeNode input = new TreeNode(
        1,
        null,
        new TreeNode(2, null, null)
    );
    Solution s = new Solution();
    List<Integer> output = s.largestValues(input);
    boolean passed = Arrays.equals(output.toArray(), new Integer[] {1,2});
    System.out.println("tes3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    TreeNode input = new TreeNode(1, null, null);
    Solution s = new Solution();
    List<Integer> output = s.largestValues(input);
    boolean passed = Arrays.equals(output.toArray(), new Integer[] {1});
    System.out.println("tes4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    TreeNode input = null;
    Solution s = new Solution();
    List<Integer> output = s.largestValues(input);
    boolean passed = Arrays.equals(output.toArray(), new Integer[] {});
    System.out.println("tes5: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
  }
}
