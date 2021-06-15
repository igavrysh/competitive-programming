package com.company;

public class Main {

  public static void test1() {
    int[] input = {2,5,6,0,0,1,2};
    int target = 0;
    Solution s = new Solution();
    boolean output = s.search(input, target);
    boolean passed = output == true;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] input = {2,5,6,0,0,1,2};
    int target = 3;
    Solution s = new Solution();
    boolean output = s.search(input, target);
    boolean passed = output == false;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] input = {2,5,6,0,0,1,2};
    int target = 2;
    Solution s = new Solution();
    boolean output = s.search(input, target);
    boolean passed = output == true;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[] input = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
    int target = 2;
    Solution s = new Solution();
    boolean output = s.search(input, target);
    boolean passed = output == true;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    int[] input = {0,0,1,1,2,0};
    int target = 2;
    Solution s = new Solution();
    boolean output = s.search(input, target);
    boolean passed = output == true;
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    int[] input = {1,0,1,1,1};
    int target = 0;
    Solution s = new Solution();
    boolean output = s.search(input, target);
    boolean passed = output == true;
    System.out.println("test6: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
  }
}
