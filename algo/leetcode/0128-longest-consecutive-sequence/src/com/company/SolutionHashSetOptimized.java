package com.company;

import java.util.HashSet;

public class SolutionHashSetOptimized {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> M = new HashSet<>();
        for (int num : nums) {
            M.add(num);
        }

        HashSet<Integer> visited = new HashSet<>();
        int maxSeq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums.length-i < maxSeq) {
                break;
            }
            if (M.contains(nums[i]) && !visited.contains(nums[i])) {
                int seq = 1;
                visited.add(nums[i]);

                int j = nums[i]+1;
                while (M.contains(j)) {
                    visited.add(j);
                    seq++; j++;
                }
                j = nums[i]-1;
                while (M.contains(j)) {
                    visited.add(j);
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
