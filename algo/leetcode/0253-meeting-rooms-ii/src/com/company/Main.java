package com.company;

public class Main {

  public static void test1() {
    int[][] intervals = {{5,10},{0,30},{15,20}};
    Solution s = new Solution();
    int output = s.minMeetingRooms(intervals);
    boolean passed = output == 2;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[][] intervals = {{1,10},{2,7},{3,19},{8,12},{10,20},{11,30}};
    Solution s = new Solution();
    int output = s.minMeetingRooms(intervals);
    boolean passed = output == 4;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
