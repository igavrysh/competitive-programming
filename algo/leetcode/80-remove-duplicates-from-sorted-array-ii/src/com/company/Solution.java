package com.company;

public class Solution {

  public int removeDuplicates(int[] nums) {
    int numsI = 1;
    int i = 0;
    int length = 1;
    int counter = 1;
    while (numsI < nums.length) {
      if (nums[i] != nums[numsI] || counter < 2) {
        if (nums[i] != nums[numsI]) {
          nums[i + 1] = nums[numsI];
          counter = 1;
        } else if (counter < 2) {
          nums[i + 1] = nums[numsI];
          counter++;
        }
        i++;
        length++;
      }
      numsI++;
    }
    return length;
  }
}
