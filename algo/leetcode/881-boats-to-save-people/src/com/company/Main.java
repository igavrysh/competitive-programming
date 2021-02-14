package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution();
    int output = s.numRescueBoats(new int[] {1, 2}, 3);
    boolean passed = output == 1;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution s = new Solution();
    int output = s.numRescueBoats(new int[] {3,2,2,1}, 3);
    boolean passed = output == 3;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution s = new Solution();
    int output = s.numRescueBoats(new int[] {3,2,3,2,2}, 6);
    boolean passed = output == 3;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    Solution s = new Solution();
    int output = s.numRescueBoats(new int[] {5,1,7,4,2,4}, 7);
    boolean passed = output == 4;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
