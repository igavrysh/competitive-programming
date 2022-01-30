package com.company;

class SolutionFaster {
  public void rotate(int[] nums, int k) {
    k=k%nums.length;
    for (int i = 1; i < k; i++) {
        cycle(i, nums, k);
    }
    
  }

  private void cycle(int s, int[] nums, int k) {
    int nextIdx = (s+k)%nums.length;
    int tmp = nums[s];
    int i = s;
    boolean firstPassed = false;
    while (!(i==s && firstPassed==true)) {
      firstPassed = true;
      nextIdx = (i+k)%nums.length;
      int tmp2  = nums[nextIdx];
      nums[nextIdx] = tmp; 
      tmp = tmp2;
      i=nextIdx;
    }
  }
}