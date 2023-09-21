// Time: O(N)
// Space: O(1)

public class Solution5Dp {
    public boolean increasingTriplet(int[] nums) {
        // dp[i] = index of last minimal element of strictly increasing sequence of length i
        int[] dp = new int[3];
        dp[0] = -1; // just filler - not used
        dp[1] = 0;
        dp[2] = -1;

        for (int i = 1; i < nums.length; i++) {
            // update for seq length = 1
            if (nums[dp[1]] > nums[i]) {
                dp[1] = i;
            }

            if ((dp[2] == -1 || nums[dp[2]] > nums[i]) && nums[dp[1]] < nums[i]) {
                dp[2] = i;
            }

            if (dp[2] != -1 && nums[dp[2]] < nums[i]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        testSolution5Dp1();
        testSolution5Dp2();
        testSolution5Dp3();
    }

    public static void testSolution5Dp1() {
        int[] nums = {1,2,3,4,5};
        Solution5Dp s = new Solution5Dp();
        boolean output = s.increasingTriplet(nums);
        boolean expected = true;
        boolean passed = output == expected;
        System.out.println("testSolution5Dp1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution5Dp2() {
        int[] nums = {5,4,3,2,1};
        Solution5Dp s = new Solution5Dp();
        boolean output = s.increasingTriplet(nums);
        boolean expected = false;
        boolean passed = output == expected;
        System.out.println("testSolution5Dp2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution5Dp3() {
        int[] nums = {2,1,5,0,4,6};
        Solution5Dp s = new Solution5Dp();
        boolean output = s.increasingTriplet(nums);
        boolean expected = true;
        boolean passed = output == expected;
        System.out.println("testSolution5Dp3: " + (passed ? "passed" : "failed"));
    }
}
