package com.company;

public class Solution3 {
  public void sortColors(int[] nums) {
    // Unknown area = Mid..Hi
    // ZeroesArea = 0..Low-1
    // OnesArea = Low..Mid-1
    // TwosArea = Hi+1..N-1
    int low = 0;
    int mid = 0;
    int hi = nums.length-1;
    while (mid <= hi) {
      if (nums[mid] == 0) {
        int tmp = nums[low];
        nums[low] = 0;
        low++;
        mid++;
        if (mid-1 >= low) {
          nums[mid-1] = 1;
        }
      } else if (nums[mid] == 2) {
        nums[mid] = nums[hi];
        nums[hi] = 2;
        hi--;

      } else if (nums[mid] == 1) {
        nums[mid] = 1;
        mid++;
      }
    }
  }
}
