package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionPractice2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        BT(0, new ArrayList<>(), output, nums);
        return output;
    }

    private void BT(int idx, List<Integer> acc, List<List<Integer>> output, int[] nums) {
        if (idx == nums.length) {
            boolean lastAddedMatches = false;
            if (output.size() > 0) {
                List<Integer> lastAdded = output.get(output.size()-1);
                if (acc.size() == lastAdded.size()) {
                    boolean allMatch = true;
                    for (int i = 0; i < acc.size(); i++) {
                        if (acc.get(i) != lastAdded.get(i)) {
                            allMatch = false;
                            break;
                        }
                    }
                    if (allMatch == true) {
                        lastAddedMatches = true;
                    }
                }
            }
            if (!lastAddedMatches) {
                output.add(new ArrayList<>(acc));
            }
            return;
        }
        BT(idx+1, acc, output, nums);
        acc.add(nums[idx]);
        BT(idx+1, acc, output, nums);
        acc.remove(acc.size()-1);
    }
    
    public static void main(String[] args) {
        //testSolutionPractice2_1();
        testSolutionPractice2_2();
    }

    public static void testSolutionPractice2_1() {
        int[] nums = {1,2,2};
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.subsetsWithDup(nums);
        int t = 1;
    }

    public static void testSolutionPractice2_2() {
        int[] nums = {1,2};
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.subsetsWithDup(nums);
        int t = 1;
    }

}
