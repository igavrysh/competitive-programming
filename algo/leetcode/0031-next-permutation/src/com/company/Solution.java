package com.company;

public class Solution {
  public void nextPermutation(int[] nums) {
    boolean arrayChanged = false;
    for (int i = nums.length-1; i >= 1; i--) {
      if (nums[i-1] < nums[i]) {
        arrayChanged = true;
        int nextMinI = -1;
        int nextMinValue = Integer.MAX_VALUE;
        for (int j = i; j < nums.length; j++) {
          if (nums[j] > nums[i-1] && nextMinValue >= nums[j]) {
            nextMinI = j;
            nextMinValue = nums[j];
          }
        }

        // Insert j-1 element b/w j and length-1
        // Move nextMinI element to j-1 position

        int tmp = nums[i-1];
        nums[i-1] = nextMinValue;
        nums[nextMinI] = tmp;
        int increment = 0;
        int k = nextMinI;
        if (k+1 < nums.length && nums[k] < nums[k+1]) {
          increment = 1;
        } else if (k-1 >= 0 && nums[k] > nums[k-1]) {
          increment = -1;
        }
        while (increment != 0
            && k+increment < nums.length
            && k+increment >= 0
        ) {
          tmp = nums[k+increment];
          nums[k] = nums[k+increment];
          nums[k+increment] = tmp;
          k = k+increment;
          if (k < 0 || k >= nums.length) {
            increment = 0;
          } else if (increment > 0 && k+1 < nums.length && nums[k] > nums[k+1]) {
            increment = 0;
          } else if (increment < 0 && k-1 >= 0 && nums[k] < nums[k-1]) {
            increment = 0;
          }
        }

        for (int s = 0; s <= (nums.length-1 - (i))/2; s++) {
          tmp = nums[nums.length - 1 - s];
          nums[nums.length-1-s] = nums[i+s];
          nums[i+s] = tmp;
        }
        i = 0;
      }
    }

    if (arrayChanged == false) {
      for (int s = 0; s <= (nums.length-1)/2; s++) {
        int tmp = nums[nums.length - 1 - s];
        nums[nums.length-1-s] = nums[s];
        nums[s] = tmp;
      }
    }
  }
}
