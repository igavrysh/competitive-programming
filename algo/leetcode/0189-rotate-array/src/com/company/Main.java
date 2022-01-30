package com.company;

import java.util.Arrays;

class Main {
  
  public static void test1() {
    int[] nums = {1,2,3,4,5,6,7};
    int k = 3;
    Solution s = new Solution();
    s.rotate(nums, k);
    boolean passed = Arrays.equals(nums, new int[]{5,6,7,1,2,3,4});
    System.out.println("test1: " + (passed ? "passed" : "failed") );
  }

  public static void main(String[] args) {
    test1();
  }
}