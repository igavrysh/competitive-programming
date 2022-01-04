package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void test1() {
    TreeNode n = new TreeNode(3);
    TreeNode nl = new TreeNode(5);
    TreeNode nr = new TreeNode(1);
    n.left = nl;
    n.right = nr;

    TreeNode nr_l = new TreeNode(0);
    TreeNode nr_r = new TreeNode(8);
    nr.left = nr_l;
    nr.right = nr_r;

    TreeNode nl_l = new TreeNode(6);
    TreeNode nl_r = new TreeNode(2);
    nl.left = nl_l;
    nl.right = nl_r;

    TreeNode nl_r_l = new TreeNode(7);
    TreeNode nl_r_r = new TreeNode(4);
    nl_r.left = nl_r_l;
    nl_r.right = nl_r_r;

    Solution s = new Solution();
    List<Integer> output = s.distanceK(n, nl, 2);

    boolean passed = output.containsAll(Arrays.asList(new Integer[]{1,7,4})) && output.size() == 3;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    TreeNode n = new TreeNode(3);
    TreeNode nl = new TreeNode(5);
    TreeNode nr = new TreeNode(1);
    n.left = nl;
    n.right = nr;

    TreeNode nr_l = new TreeNode(0);
    TreeNode nr_r = new TreeNode(8);
    nr.left = nr_l;
    nr.right = nr_r;

    TreeNode nl_l = new TreeNode(6);
    TreeNode nl_r = new TreeNode(2);
    nl.left = nl_l;
    nl.right = nl_r;

    TreeNode nl_r_l = new TreeNode(7);
    TreeNode nl_r_r = new TreeNode(4);
    nl_r.left = nl_r_l;
    nl_r.right = nl_r_r;

    Solution s = new Solution();
    List<Integer> output = s.distanceK(n, nl_r_l, 0);

    boolean passed = output.containsAll(Arrays.asList(new Integer[]{7})) && output.size() == 1;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    TreeNode n = new TreeNode(1);

    Solution s = new Solution();
    List<Integer> output = s.distanceK(n, n, 3);

    boolean passed = output.size() == 0;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void testDist1() {
    TreeNode n = new TreeNode(3);
    TreeNode nl = new TreeNode(5);
    TreeNode nr = new TreeNode(1);
    n.left = nl;
    n.right = nr;

    TreeNode nr_l = new TreeNode(0);
    TreeNode nr_r = new TreeNode(8);
    nr.left = nr_l;
    nr.right = nr_r;

    TreeNode nl_l = new TreeNode(6);
    TreeNode nl_r = new TreeNode(2);
    nl.left = nl_l;
    nl.right = nl_r;

    TreeNode nl_r_l = new TreeNode(7);
    TreeNode nl_r_r = new TreeNode(4);
    nl_r.left = nl_r_l;
    nl_r.right = nl_r_r;

    SolutionWithDistance s = new SolutionWithDistance();
    List<Integer> output = s.distanceK(n, nl, 2);

    boolean passed = output.containsAll(Arrays.asList(new Integer[]{1,7,4})) && output.size() == 3;
    System.out.println("testDist1: " + (passed ? "passed" : "failed"));
  }

  public static void testDist2() {
    TreeNode n = new TreeNode(3);
    TreeNode nl = new TreeNode(5);
    TreeNode nr = new TreeNode(1);
    n.left = nl;
    n.right = nr;

    TreeNode nr_l = new TreeNode(0);
    TreeNode nr_r = new TreeNode(8);
    nr.left = nr_l;
    nr.right = nr_r;

    TreeNode nl_l = new TreeNode(6);
    TreeNode nl_r = new TreeNode(2);
    nl.left = nl_l;
    nl.right = nl_r;

    TreeNode nl_r_l = new TreeNode(7);
    TreeNode nl_r_r = new TreeNode(4);
    nl_r.left = nl_r_l;
    nl_r.right = nl_r_r;

    SolutionWithDistance s = new SolutionWithDistance();
    List<Integer> output = s.distanceK(n, nl_r_l, 0);

    boolean passed = output.containsAll(Arrays.asList(new Integer[]{7})) && output.size() == 1;
    System.out.println("testDist2: " + (passed ? "passed" : "failed"));
  }

  public static void testDist3() {
    // root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
    TreeNode n = new TreeNode(1);


    SolutionWithDistance s = new SolutionWithDistance();
    List<Integer> output = s.distanceK(n, n, 3);

    boolean passed = output.size() == 0;
    System.out.println("testDist3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();

    testDist1();
    testDist2();
    testDist3();
  }
}
