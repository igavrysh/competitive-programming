package com.company;

// video with explanation:
// https://www.youtube.com/watch?v=YA-nB2wjVcI
public class SolutionOptimized {
    // Time: O(N)
    // Space: O(1), without input array modifications
    public int majorityElement(int[] nums) {
        int curr = nums[0];
        int currFq = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == curr) {
                currFq++;
            } else {  // e.g. nums[i] != curr
                if (currFq > 0) {
                    currFq--;
                } else {
                    curr = nums[i];
                    currFq = 1;
                }
            } 
        }

        // additional pass for exhaustiveness - not needed as in problem statement
        // majority element always exists
        boolean checkForExhaustness = false;
        if (checkForExhaustness) {
            int counter = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == curr) {
                    counter++;
                }
            }
            if (counter > nums.length/2) {
                return curr;
            }
        }
        
        return curr;
    }
}
