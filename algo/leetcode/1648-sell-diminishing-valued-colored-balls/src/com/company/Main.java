package com.company;

public class Main {

  public static String getMethodName() {
    return new Throwable()
        .getStackTrace()[1]
        .getMethodName();
  }

  public static void testTimeLimitExceeded1() {
    int[] inventory = {2,5};
    int orders = 4;
    SolutionTimeLimitExceeded s = new SolutionTimeLimitExceeded();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 14;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testTimeLimitExceeded2() {
    int[] inventory = {3,5};
    int orders = 6;
    SolutionTimeLimitExceeded s = new SolutionTimeLimitExceeded();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 19;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testTimeLimitExceeded3() {
    int[] inventory = {1000000000};
    int orders = 1000000000;
    SolutionTimeLimitExceeded s = new SolutionTimeLimitExceeded();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 21;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testTimeLimitExceeded4() {
    int[] inventory = {701695700,915736894,35093938,364836059,452183894,951826038,861556610,441929847,842650446,858413011,457896886,35119509,776620034,396643588,83585103,681609037};
    int orders = 598226067;
    SolutionTimeLimitExceeded s = new SolutionTimeLimitExceeded();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 525803723;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testTimeLimitExceeded5() {
    int[] inventory = {5, 3, 10};
    int orders = 2;
    SolutionTimeLimitExceeded s = new SolutionTimeLimitExceeded();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 19;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testTimeLimitExceeded6() {
    int[] inventory = {5, 3, 10};
    int orders = 6;
    SolutionTimeLimitExceeded s = new SolutionTimeLimitExceeded();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 45;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testTimeLimitExceeded7() {
    int[] inventory = {5, 3, 10};
    int orders = 16;
    SolutionTimeLimitExceeded s = new SolutionTimeLimitExceeded();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 74;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void test1() {
    int[] inventory = {2,5};
    int orders = 4;
    Solution s = new Solution();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 14;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] inventory = {3,5};
    int orders = 6;
    Solution s = new Solution();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 19;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int[] inventory = {1000000000};
    int orders = 1000000000;
    Solution s = new Solution();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 21;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int[] inventory = {701695700,915736894,35093938,364836059,452183894,951826038,861556610,441929847,842650446,858413011,457896886,35119509,776620034,396643588,83585103,681609037};
    int orders = 598226067;
    Solution s = new Solution();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 525803723;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void test5() {
    int[] inventory = {5, 3, 10};
    int orders = 2;
    Solution s = new Solution();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 19;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void test6() {
    int[] inventory = {5, 3, 10};
    int orders = 6;
    Solution s = new Solution();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 45;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void test7() {
    int[] inventory = {5, 3, 10};
    int orders = 16;
    Solution s = new Solution();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 74;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testSort1() {
    int[] inventory = {2,5};
    int orders = 4;
    SolutionSort s = new SolutionSort();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 14;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }


  public static void testSort2() {
    int[] inventory = {3,5};
    int orders = 6;
    SolutionSort s = new SolutionSort();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 19;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }


  public static void testSort3() {
    int[] inventory = {1000000000};
    int orders = 1000000000;
    SolutionSort s = new SolutionSort();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 21;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testSort31() {
    int[] inventory = {2,1,5};
    int orders = 8;
    SolutionSort s = new SolutionSort();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 19;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testSort4() {
    int[] inventory = {701695700,915736894,35093938,364836059,452183894,951826038,861556610,441929847,842650446,858413011,457896886,35119509,776620034,396643588,83585103,681609037};
    int orders = 598226067;
    SolutionSort s = new SolutionSort();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 525803723;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testSort5() {
    int[] inventory = {5, 3, 10};
    int orders = 2;
    SolutionSort s = new SolutionSort();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 19;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testSort6() {
    int[] inventory = {5, 3, 10};
    int orders = 6;
    SolutionSort s = new SolutionSort();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 45;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }

  public static void testSort7() {
    int[] inventory = {5, 3, 10};
    int orders = 16;
    SolutionSort s = new SolutionSort();
    int output = s.maxProfit(inventory, orders);
    boolean passed = output == 74;
    System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
  }


  public static void main(String[] args) {
    testTimeLimitExceeded1();
    testTimeLimitExceeded2();
    // Excluded due to performance issues
    //testTimeLimitExceeded3();
    //testTimeLimitExceeded4();
    testTimeLimitExceeded5();
    testTimeLimitExceeded6();
    testTimeLimitExceeded7();

    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
    test7();

    testSort1();
    testSort2();
    testSort3();
    testSort31();
    testSort4();
    testSort5();
    testSort6();
    testSort7();
  }
}
