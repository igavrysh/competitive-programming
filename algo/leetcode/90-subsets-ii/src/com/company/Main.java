package com.company;

import java.util.List;

public class Main {

    public static void test1() {
        int[] nums = {1, 2, 2};
        Solution s = new Solution();
        List<List<Integer>> output = s.subsetsWithDup(nums);
        int t = 1;
    }

    public static void main(String[] args) {
        test1();
    }

}
