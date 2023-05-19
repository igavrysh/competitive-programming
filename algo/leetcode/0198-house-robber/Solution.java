class Solution {
    public int rob(int[] nums) {
        int[] DP = new int[nums.length];
        DP[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            DP[i] = Math.max(nums[i] + (i>=2 ? DP[i-2] : 0), DP[i-1]);
        }

        return DP[nums.length-1];
    }

    public static void main(String[] args) {
        testSolution_1();
        testSolution_2();
    }

    public static void testSolution_1() {
        int[] nums = {1,2,3,1};
        int expectedOutput = 4;
        Solution s = new Solution();
        int output = s.rob(nums);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        int[] nums = {2,7,9,3,1};
        int expectedOutput = 12;
        Solution s = new Solution();
        int output = s.rob(nums);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));
    }
}