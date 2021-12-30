package com.company;

public class Main {

  public static String getMethodName() {
    return new Throwable()
        .getStackTrace()[1]
        .getMethodName();
  }

  public static void test1() {
    int[] input = {5,5,4};
    int k = 1;
    Solution s = new Solution();
    int output = s.findLeastNumOfUniqueInts(input, k);
    boolean passed = output == 1;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] input = {4,3,1,1,3,3,2};
    int k = 3;
    Solution s = new Solution();
    int output = s.findLeastNumOfUniqueInts(input, k);
    boolean passed = output == 2;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] input = {1,1,2,2,3,3};
    int k = 3;
    Solution s = new Solution();
    int output = s.findLeastNumOfUniqueInts(input, k);
    boolean passed = output == 2;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testHashTreeMap1() {
    int[] input = {1,1,2,2,3,3};
    int k = 3;
    SolutionHashTreeMap s = new SolutionHashTreeMap();
    int output = s.findLeastNumOfUniqueInts(input, k);
    boolean passed = output == 2;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testArray1() {
    int[] input = {1,1,2,2,3,3};
    int k = 3;
    SolutionArray s = new SolutionArray();
    int output = s.findLeastNumOfUniqueInts(input, k);
    boolean passed = output == 2;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {

    test1();
    test2();
    test3();

    testHashTreeMap1();

    testArray1();
  }
}
