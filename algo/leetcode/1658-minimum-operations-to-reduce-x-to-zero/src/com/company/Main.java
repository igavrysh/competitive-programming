package com.company;

public class Main {

  public static void test1() {
    int[] input = {1,1,4,2,3};
    Solution s = new Solution();
    int output = s.minOperations(input, 5);
    boolean passed = output == 2;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] input = {5,6,7,8,9};
    Solution s = new Solution();
    int output = s.minOperations(input, 4);
    boolean passed = output == -1;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] input = {3,2,20,1,1,3};
    Solution s = new Solution();
    int output = s.minOperations(input, 10);
    boolean passed = output == 5;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[] input = {5,2,3,1,1};
    Solution s = new Solution();
    int output = s.minOperations(input, 5);
    boolean passed = output == 1;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    int[] input = {1,1};
    Solution s = new Solution();
    int output = s.minOperations(input, 3);
    boolean passed = output == -1;
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    int[] input = {8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309};
    Solution s = new Solution();
    int output = s.minOperations(input, 134365);
    boolean passed = output == 16;
    System.out.println("test6: " + (passed ? "passed" : "failed"));
  }


  public static void test7() {
    int[] input = {5,1,4,2,3};
    Solution s = new Solution();
    int output = s.minOperations(input, 6);
    boolean passed = output == 2;
    System.out.println("test7: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
    test7();
  }
}
