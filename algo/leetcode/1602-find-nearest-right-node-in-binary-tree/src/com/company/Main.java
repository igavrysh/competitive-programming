package com.company;

public class Main {

  public static void test1() {
    TreeNode one = new TreeNode(1), two = new TreeNode(2),three = new TreeNode(3),
      four = new TreeNode(4), five = new TreeNode(5), six = new TreeNode(6);

    one.left = two;
    one.right = three;
    two.right = four;
    three.left = five;
    three.right = six;

    Solution s = new Solution();
    TreeNode output = s.findNearestRightNode(one, four);
    boolean passed = output == five;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    TreeNode one = new TreeNode(1), four = new TreeNode(4), two = new TreeNode(2);
    one.right = four;
    four.left = two;
    Solution s = new Solution();
    TreeNode output = s.findNearestRightNode(one, two);
    boolean passed = output == null;
    System.out.println("test2 :" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    TreeNode n3 = new TreeNode(3), n10 = new TreeNode(10), n1 = new TreeNode(1), n7 = new TreeNode(7),
      n8 = new TreeNode(8), n9 = new TreeNode(9), n4 = new TreeNode(4), n2 = new TreeNode(2), 
      n11 = new TreeNode(11), n5 = new TreeNode(5), n6 = new TreeNode(6);
    n3.left = n10;
    n3.right = n1;
    n10.left = n7;
    n10.right = n8;
    n1.left = n9;
    n1.right = n4;
    n8.left = n2;
    n9.right = n11;
    n11.left = n5;
    n5.left = n6;
    Solution s = new Solution();
    TreeNode output = s.findNearestRightNode(n3, n4);
    boolean passed = output == null;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
}
