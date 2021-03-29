package com.company;

public class Main {

  public static void test1() {
    Solution s = new Solution(new int[] {1});
    boolean passed = s.pickIndex() == 0
        && s.pickIndex() == 0
        && s.pickIndex() == 0;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    SolutionOptimized s = new SolutionOptimized(new int[] {1});
    boolean passed = s.pickIndex() == 0
        && s.pickIndex() == 0
        && s.pickIndex() == 0;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    SolutionOptimized s = new SolutionOptimized(new int[] {1,3});
    int count0 = 0;
    int count1 = 0;
    for (int i = 0; i < 1000000; i++) {
      int t = s.pickIndex();
      if (t == 0) {
        count0++;
      } else if (t == 1) {
        count1++;
      }
    }

    double count0Freq = count0 * 1.0 / (count0 + count1);
    double count1Freq = count1 * 1.0 / (count0 + count1);

    boolean passed = Math.abs(count0Freq * 100 - 25) < 1
        && Math.abs(count1Freq * 100 - 75) < 1;
    System.out.println("test3: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    //test1();
    //test2();
    test3();
  }
}
