class Solution {
    public int rob(int[] nums) {
        return nums.length == 1 
            ? nums[0] 
            : Math.max(DP(nums, 0, nums.length-2), DP(nums, 1, nums.length-1));       
    }

    private int DP(int[] nums, int s, int e) {
        int prevPrevMax = 0, prevMax = 0;
        for (int i = s; i <= e; i++) {
            int max = Math.max(nums[i] + prevPrevMax, prevMax);
            prevPrevMax = prevMax;
            prevMax = max;
        }
        return prevMax;
    }
}