package com.company;

class SolutionFaster {
  public void rotate(int[] nums, int k) {
    k=k%nums.length;
    int count = 0;
    for (int s = 0; count < nums.length; s++) {
      int nextIdx = (s+k)%nums.length;
      int tmp = nums[s];
      int i = s;
      boolean firstPassed = false;
      while (!(i==s && firstPassed==true)) {
        firstPassed = true;
        nextIdx = (i+k)%nums.length;
        int tmp2  = nums[nextIdx];
        nums[nextIdx] = tmp; 
        count++;
        tmp = tmp2;
        i=nextIdx;
      }
    } 
  }
}