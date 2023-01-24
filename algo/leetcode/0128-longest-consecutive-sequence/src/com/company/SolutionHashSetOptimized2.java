package com.company;

import java.util.HashSet;

public class SolutionHashSetOptimized2 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> M = new HashSet<>();
        for (int num : nums) {
            M.add(num);
        }

        int maxSeq = 0;
        for (int i = 0; i < nums.length; i++) {
            int seq = 0;
            if (M.contains(nums[i]) && !M.contains(nums[i]-1)) {
                seq = 1; int num = nums[i]+1;
                while (M.contains(num)) {
                    seq++;
                    num++;
                }
                if (seq > maxSeq) {
                    maxSeq = seq;
                }
            }
        }

        return maxSeq;
    }
}
