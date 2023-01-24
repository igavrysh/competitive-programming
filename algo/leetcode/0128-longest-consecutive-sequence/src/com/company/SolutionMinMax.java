package com.company;

import java.util.HashSet;

public class SolutionMinMax {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length > 1000) {
            return new SolutionHashSetOptimized().longestConsecutive(nums);
        }

        int min = nums[0]; int max = nums[0];
        for (int num : nums) {
            if (num < min) { min = num; }
            if (num > max) { max = num; }
        }

        if (max-min+1> 1000) {
            return new SolutionHashSetOptimized().longestConsecutive(nums);
        }


        int[] fqs = new int[max-min+1];
        for (int num : nums) {
            fqs[num-min] = 1;
        } 

        int result = 0;
        int counter = 0;
        for (int fq : fqs) {
            if (fq > 0) {
                counter++;
            } else {
                if (result < counter) {
                    result = counter;
                }
                counter = 0;
            }
        }
        if (result < counter) {
            result = counter;
        }
        return result;
    }


    class SolutionHashSetOptimized {
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
}