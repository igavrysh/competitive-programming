package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), output);
        return output;
    }

    private void helper(int[] nums, int s, List<Integer> curr, List<List<Integer>> output) {
        if (s >= nums.length) {
            boolean alreadyContains = false;
            for (List<Integer> c : output) {
                if (c.equals(curr)) {
                    alreadyContains = true;
                }
            }
            if (!alreadyContains) {
                List<Integer> currCopy = new ArrayList<>(curr);
                output.add(currCopy);
            }
            return;
        }

        helper(nums, s+1, curr, output);
        curr.add(nums[s]);
        helper(nums, s+1, curr, output);
        curr.remove(curr.size() - 1);
    }
}
