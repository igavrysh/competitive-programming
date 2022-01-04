package com.company;

public class SolutionQuickSelect {

  public int findKthLargest(int[] nums, int k) {
    int l = 0, r = nums.length-1;
    while (l <= r) {
      int m = l == r ? l : partition(l, r, nums);
      if (m == nums.length - k) {
        return nums[m];
      } else if (m > nums.length - k) {
        r = m-1;
      } else {
        l = m+1;
      }
    }
    return -1;
  }

  private int partition(int l, int r, int[] nums) {
    int v = nums[l];
    int i = l;
    int j = r+1;
    while (i < j) {
      while (v > nums[++i]) {
        if (i == r) {
          break;
        }
      }
      while (v < nums[--j]) {
        if (j == l) {
          break;
        }
      }

      if (i >= j) {
        break;
      }
      exch(i, j, nums);
    }

    exch(l, j, nums);
    return j;
  }

  private void exch(int i, int j, int[] nums) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

}
