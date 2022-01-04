package com.company;

public class Main {

  public static void test1() {
    int target = 100;
    int startFuel = 10;
    int[][] stations = {{10,60},{20,30},{30,30},{60,40}};
    Solution s = new Solution();
    int output = s.minRefuelStops(target, startFuel, stations);
    boolean passed = output == 2;
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int target = 100;
    int startFuel = 1;
    int[][] stations = {{10,100}};
    Solution s = new Solution();
    int output = s.minRefuelStops(target, startFuel, stations);
    boolean passed = output == -1;
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void test3() {
    int target = 1;
    int startFuel = 1;
    int[][] stations = {};
    Solution s = new Solution();
    int output = s.minRefuelStops(target, startFuel, stations);
    boolean passed = output == 0;
    System.out.println("test3:" + (passed ? "passed" : "failed"));
  }

  public static void test4() {
    int target = 1000000;
    int startFuel = 8663;
    int[][] stations = {
        {31,195796},{42904,164171},{122849,139112},{172890,121724},{182747,90912},
        {194124,112994},{210182,101272},{257242,73097},{284733,108631},{369026,25791},
        {464270,14596},{470557,59420},{491647,192483},{516972,123213},{577532,184184},
        {596589,143624},{661564,154130},{705234,100816},{721453,122405},{727874,6021},
        {728786,19444},{742866,2995},{807420,87414},{922999,7675},{996060,32691}
    };
    Solution s = new Solution();
    int output = s.minRefuelStops(target, startFuel, stations);
    boolean passed = output == 6;
    System.out.println("test4: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    //test1();
    //test2();
    //test3();
    test4();
  }
}
