package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    int[] a = new int[] { 1, 2, 3 };
    s.nextPermutation(a);
    boolean passed = a[0] == 1
        && a[1] == 3
        && a[2] == 2;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    int[] a = new int[] { 1, 2, 3, 4};
    s.nextPermutation(a);
    boolean passed = a[0] == 1
        && a[1] == 2
        && a[2] == 4
        && a[3] == 3;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution s = new Solution();
    int[] a = new int[] { 1, 2, 4, 3};
    s.nextPermutation(a);
    boolean passed = a[0] == 1
        && a[1] == 3
        && a[2] == 2
        && a[3] == 4;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    Solution s = new Solution();
    int[] a = new int[] { 1, 3, 2, 4};
    s.nextPermutation(a);
    boolean passed = a[0] == 1
        && a[1] == 3
        && a[2] == 4
        && a[3] == 2;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    Solution s = new Solution();
    int[] a = new int[] { 1, 3, 4, 2};
    s.nextPermutation(a);
    boolean passed = a[0] == 1
        && a[1] == 4
        && a[2] == 2
        && a[3] == 3;
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    Solution s = new Solution();
    int[] a = new int[] { 1, 4, 2, 3};
    s.nextPermutation(a);
    boolean passed = a[0] == 1
        && a[1] == 4
        && a[2] == 3
        && a[3] == 2;
    System.out.println("test6: " + (passed ? "passed" : "failed"));
  }

  public static void test7() {
    Solution s = new Solution();
    int[] a = new int[] { 1, 4, 3, 2};
    s.nextPermutation(a);
    boolean passed = a[0] == 2
        && a[1] == 1
        && a[2] == 3
        && a[3] == 4;
    System.out.println("test7: " + (passed ? "passed" : "failed"));
  }

  public static void test8() {
    Solution s = new Solution();
    int[] a = new int[] { 3, 2, 1};
    s.nextPermutation(a);
    boolean passed = a[0] == 1
        && a[1] == 2
        && a[2] == 3;
    System.out.println("test8: " + (passed ? "passed" : "failed"));
  }

  public static void test9() {
    Solution s = new Solution();
    int[] a = new int[] { 1 };
    s.nextPermutation(a);
    boolean passed = a[0] == 1;
    System.out.println("test9: " + (passed ? "passed" : "failed"));
  }

  public static void test10() {
    Solution s = new Solution();
    int[] a = new int[] { 2, 3, 1, 3, 3 };
    s.nextPermutation(a);
    boolean passed = a[0] == 2
        && a[1] == 3
        && a[2] == 3
        && a[3] == 1
        && a[4] == 3;
    System.out.println("test10: " + (passed ? "passed" : "failed"));
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
    test9();

    test10();
  }
}
