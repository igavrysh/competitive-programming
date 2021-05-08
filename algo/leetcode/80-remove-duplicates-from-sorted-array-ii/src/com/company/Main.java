package com.company;

public class Main {

  public static void test1() {
    int[] nums = {1,1,1,2,2,3};
    Solution s = new Solution();
    int output = s.removeDuplicates(nums);
    boolean passed = output == 5
        && nums[0] == 1
        && nums[1] == 1
        && nums[2] == 2
        && nums[3] == 2
        && nums[4] == 3;
    System.out.println("test1: " + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    int[] nums = {0,0,1,1,1,1,2,3,3};
    Solution s = new Solution();
    int output = s.removeDuplicates(nums);
    boolean passed = output == 7
        && nums[0] == 0
        && nums[1] == 0
        && nums[2] == 1
        && nums[3] == 1
        && nums[4] == 2
        && nums[5] == 3
        && nums[6] == 3;
    System.out.println("test2: " + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
