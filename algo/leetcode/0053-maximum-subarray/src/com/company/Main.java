package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    int output = s.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    boolean passed = output == 6;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    int output = s.maxSubArray(new int[]{1});
    boolean passed = output == 1;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution s = new Solution();
    int output = s.maxSubArray(new int[]{-2147483647});
    boolean passed = output == -2147483647;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    Solution s = new Solution();
    int output = s.maxSubArray(new int[]{-2, 1});
    boolean passed = output == 1;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
