package com.company;

import java.util.HashSet;

class SolutionHashSet {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> M = new HashSet<>();
        for (int num : nums) {
            M.add(num);
        }

        int maxSeq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums.length-i < maxSeq) {
                break;
            }
            if (M.contains(nums[i])) {
                int seq = 1;
                int j = nums[i]+1;
                while (M.contains(j)) {
                    seq++; j++;
                }
                j = nums[i]-1;
                while (M.contains(j)) {
                    seq++; j--;
                }
                if (seq > maxSeq) {
                    maxSeq = seq;
                }
            }
        }

        return maxSeq;
    }
}