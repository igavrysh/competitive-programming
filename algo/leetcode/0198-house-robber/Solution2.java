public class Solution2 {
    public int rob(int[] nums) {
        int prevPrevMax = 0;
        int prevMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = Math.max(nums[i] + prevPrevMax, prevMax);
            prevPrevMax = prevMax;
            prevMax = max;
        }
        return prevMax;
    }

    public static void main(String[] args) {
        testSolution_1();
        testSolution_2();
    }

    public static void testSolution_1() {
        int[] nums = {1,2,3,1};
        int expectedOutput = 4;
        Solution2 s = new Solution2();
        int output = s.rob(nums);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        int[] nums = {2,7,9,3,1};
        int expectedOutput = 12;
        Solution2 s = new Solution2();
        int output = s.rob(nums);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution2_2: " + (passed ? "passed" : "failed"));
    }
}
