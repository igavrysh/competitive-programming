package com.company;

public class Main {

  public static void test1() {
    Solution solution = new Solution();
    boolean passed = solution.canPartition(new int[] {1, 5, 11, 5}) == true;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Solution solution = new Solution();
    boolean passed = solution.canPartition(new int[] {1, 2, 3, 5}) == false;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    Solution solution = new Solution();
    boolean passed = solution.canPartition(new int[] {
        28,63,95,30,39,16,36,44,37,100,61,73,32,71,100,2,37,60,23,71,
        53,70,69,82,97,43,16,33,29,5,97,32,29,78,93,59,37,88,89,79,75,
        9,74,32,81,12,34,13,16,15,16,40,90,70,17,78,54,81,18,92,75,74,59,
        18,66,62,55,19,2,67,30,25,64,84,25,76,98,59,74,87,5,93,97,68,20,
        58,55,73,74,97,49,71,42,26,8,87,99,1,16,79
    }) == true;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    Solution solution = new Solution();
    int[] input = new int [] {
        1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
        1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
        1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100
    };
    int totalSum = 0;
    for (int i : input) {
      totalSum += i;
    }

    boolean passed = solution.canPartition(input) == false;
    System.out.println("test4:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
}
