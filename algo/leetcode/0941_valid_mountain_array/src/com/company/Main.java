package com.company;

public class Main {

  public static void test1() {
    int[] arr = {2,1};
    Solution s = new Solution();
    boolean output = s.validMountainArray(arr);
    boolean passed = output == false;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] arr = {3,5,5};
    Solution s = new Solution();
    boolean output = s.validMountainArray(arr);
    boolean passed = output == false;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }
  
  public static void test3() {
    int[] arr = {0,3,2,1};
    Solution s = new Solution();
    boolean output = s.validMountainArray(arr);
    boolean passed = output == true;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
  }
    
}
