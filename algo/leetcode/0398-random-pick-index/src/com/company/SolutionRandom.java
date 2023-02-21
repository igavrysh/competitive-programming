package com.company;

import java.util.Random;

public class SolutionRandom {
    private int[] nums;
    public SolutionRandom(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        Random r = new Random();
        boolean[] visited = new boolean[nums.length];
        
        int idx = r.nextInt(nums.length);
        int curr = nums[idx];
        visited[idx] = true;
        while (curr != target) {
            idx = r.nextInt(nums.length);
            while (visited[idx]) {
                idx = (idx+1)%nums.length;
            }
            curr = nums[idx];
            visited[idx] = true;
        }

        return idx;
    }

}
