package com.company;

import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> M = new HashSet<>();
        for (int num : nums) {
            if (M.contains(num)) {
                return true;
            } else {
                M.add(num);
            }
        }
        return false;
    }
}