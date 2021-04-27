package com.company;

import java.util.Arrays;

public class Main {

  public static void test1() {
    int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
    Solution s = new Solution();
    s.rotate(input);
    boolean passed = Arrays.equals(input[0], new int[]{7,4,1})
        && Arrays.equals(input[1], new int[]{8,5,2})
        && Arrays.equals(input[2], new int[]{9,6,3});
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  /*
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

   */

  public static void test2() {
    int[][] input = {
        {5, 1,  9,  11},
        {2, 4,  8,  10},
        {13,3,  6,  7},
        {15,14, 12, 16}};
    Solution s = new Solution();
    s.rotate(input);
    boolean passed = Arrays.equals(input[0],  new int[]{15, 13, 2,  5})
        && Arrays.equals(input[1],            new int[]{14, 3,  4,  1})
        && Arrays.equals(input[2],            new int[]{12, 6,  8,  9})
        && Arrays.equals(input[3],            new int[]{16, 7,  10, 11});
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }


  public static void main(String[] args) {
    //test1();
    test2();
  }
}
