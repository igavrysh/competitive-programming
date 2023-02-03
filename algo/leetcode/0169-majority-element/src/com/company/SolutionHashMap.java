package com.company;

import java.util.HashMap;

class SolutionHashMap {
    // Time: O(N)
    // Space: O(N)
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> M = new HashMap<>();
        int maxFq = 0;
        int elem = 0;
        for (int num : nums) {
            int fq = M.getOrDefault(num, 0) + 1;
            M.put(num, fq);
            if (fq > maxFq) {
                maxFq = fq;
                elem = num;
            }
        }
        if (maxFq > nums.length / 2) {
            return elem;
        }
        return -1;
    }
}