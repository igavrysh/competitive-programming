package com.company;

public class Main {

  public static void test1() {
    int[] piles = {3,6,7,11};
    int h = 8;
    Solution s = new Solution();
    int output = s.minEatingSpeed(piles, h);
    boolean passed = output == 4;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] piles = {30,11,23,4,20};
    int h = 5;
    Solution s = new Solution();
    int output = s.minEatingSpeed(piles, h);
    boolean passed = output == 30;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] piles = {30,11,23,4,20};
    int h = 6;
    Solution s = new Solution();
    int output = s.minEatingSpeed(piles, h);
    boolean passed = output == 23;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[] piles = {312884470};
    int h = 312884469;
    Solution s = new Solution();
    int output = s.minEatingSpeed(piles, h);
    boolean passed = output == 2;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    int[] piles = {312884470};
    int h = 968709470;
    Solution s = new Solution();
    int output = s.minEatingSpeed(piles, h);
    boolean passed = output == 1;
    System.out.println("test5: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
  }
}
