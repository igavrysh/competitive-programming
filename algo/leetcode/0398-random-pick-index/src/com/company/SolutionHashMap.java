package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class SolutionHashMap {
    HashMap<Integer, List<Integer>> M = new HashMap<>();
    public SolutionHashMap(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> idxs = M.getOrDefault(nums[i], new ArrayList<>());
            idxs.add(i);
            M.put(nums[i], idxs);
        }
    }
    
    public int pick(int target) {
        List<Integer> idxs = M.get(target);
        if (idxs == null || idxs.size() == 0) {
            return -1;
        }

        Random r = new Random();
        return idxs.get(r.nextInt(idxs.size()));
    }
}