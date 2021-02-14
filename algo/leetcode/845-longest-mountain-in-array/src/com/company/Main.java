package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    int output = s.longestMountain(new int[] { 2, 1, 4, 7, 3, 2, 5 });
    boolean passed = output == 5;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    int output = s.longestMountain(new int[] { 2, 2, 2 });
    boolean passed = output == 0;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution s = new Solution();
    int output = s.longestMountain(new int[] { 2, 2, 2, 5, 8, 3, 3, 3 });
    boolean passed = output == 4;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    Solution s = new Solution();
    int output = s.longestMountain(new int[] { 1, 2, 1, 1, 2, 3, 4, 3, 2, 1, 2, 1 });
    boolean passed = output == 7;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    Solution s = new Solution();
    int output = s.longestMountain(new int[] { 0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 });
    boolean passed = output == 11;
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    Solution s = new Solution();
    int output = s.longestMountain(new int[] {0, 2, 0});
    boolean passed = output == 3;
    System.out.println("test6: " + (passed ? "passed" : "failed"));
  }

  public static void test7() {
    Solution s = new Solution();
    int output = s.longestMountain(new int[] {1, 0, 1, 0});
    boolean passed = output == 3;
    System.out.println("test7: " + (passed ? "passed" : "failed"));
  }

  public static void test8() {
    Solution s = new Solution();
    int output = s.longestMountain(new int[] {0, 1, 0, 1});
    boolean passed = output == 3;
    System.out.println("test8: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
    test7();
    test8();
  }
}
