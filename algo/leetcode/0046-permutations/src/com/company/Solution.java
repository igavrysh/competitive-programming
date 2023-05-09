package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> sNums = new HashSet<>();
        for (Integer num : nums) {
            sNums.add(num);
        }

        List<List<Integer>> output = new ArrayList<>();

        permuteInternal(
                sNums,
                nums.length,
                new ArrayList<Integer>(),
                output);

        return output;
    }

    private void permuteInternal(
            Set<Integer> nums,
            int numsRequired,
            List<Integer> partialResult,
            List<List<Integer>> output) {
        if (numsRequired == 0) {
            output.add(partialResult);
            return;
        }

        for (Integer v : nums) {
            Set<Integer> numsToPass = nums.stream()
                    .filter(s -> s != v).collect(Collectors.toSet());
            ArrayList<Integer> partialResultToPass = new ArrayList<>();
            partialResultToPass.addAll(partialResult);
            partialResultToPass.add(v);

            permuteInternal(
                    numsToPass,
                    numsRequired - 1,
                    partialResultToPass,
                    output);

        }
    }
}
