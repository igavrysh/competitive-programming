package com.company;

public class SolutionPractice2 {
    
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int minDP = nums[0], maxDP = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            int _maxDP = Math.max(nums[i], Math.max(minDP * nums[i], maxDP * nums[i]));
            int _minDP = Math.min(nums[i], Math.min(minDP * nums[i], maxDP * nums[i]));
            maxDP = _maxDP;
            minDP = _minDP;
            max = Math.max(max, maxDP);
        }
        return max;
    }

    public static void main(String[] args) {
        testSolutionPractice2_1();
        testSolutionPractice2_2();
        testSolutionPractice2_3();
    }

    public static void testSolutionPractice2_1() {
        int[] nums = {2,3,-2,4};
        int expOutput = 6;
        SolutionPractice2 sol = new SolutionPractice2();
        int output = sol.maxProduct(nums);
        boolean passed = output == expOutput;
        System.out.println("testSolutionPractice2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_2() {
        int[] nums = {-2,0,-1};
        int expOutput = 0;
        SolutionPractice2 sol = new SolutionPractice2();
        int output = sol.maxProduct(nums);
        boolean passed = output == expOutput;
        System.out.println("testSolutionPractice2_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_3() {
        int[] nums = {-2,3,-4};
        int expOutput = 24;
        SolutionPractice2 sol = new SolutionPractice2();
        int output = sol.maxProduct(nums);
        boolean passed = output == expOutput;
        System.out.println("testSolutionPractice2_3: " + (passed ? "passed" : "failed"));
    }
}
