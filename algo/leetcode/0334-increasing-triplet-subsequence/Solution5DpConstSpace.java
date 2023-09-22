// Time: O(N)
// Space: O(1)

public class Solution5DpConstSpace {
    public boolean increasingTriplet(int[] nums) {
        // dp[L] = stores index of minimal tail element of strictly increasing sequence of length L
        // update dp[1], dp[2], to maintain invariant - as you progress thru array of nums
        int[] dp = new int[3];
        dp[0] = -1; // just filler - not used
        dp[1] = 0;
        dp[2] = -1;

        for (int i = 1; i < nums.length; i++) {
            // update for seq length = 1
            // is the new tail of sequence of length 1 less than a previous tail for sequence of length 1? 
            // tivial case
            if (nums[dp[1]] > nums[i]) {
                dp[1] = i;
            }

            // with arrival of nums[i] there are 2 possibilies of for the sequence of length = 2
            // 1) nums[i] does not change anything, e.g. increasing sequence with a length of 2 does not 
            //  change its minimal tail, as its tail (nums[dp[2]]) is less than new elem (nums[i]))
            // 2) nums[i] changes the sequence of length 2, as it becomes a new minimal tail for sequence 
            //  of length 2, the following conditions should hold:
            //      1) new tail should be less than previous tail for seq of length 2: nums[i] < nums[dp[2]]
            //      2) new tail should be a "valid" tail: new tail value should be greater than minimal tail 
            //          of sequence of length 1: nums[dp[1]] < nums[i] 
            if ((dp[2] == -1 || nums[dp[2]] > nums[i]) && nums[dp[1]] < nums[i]) {
                dp[2] = i;
            }

            // can a current value be a new tail of sequence of length 3? Drop minimality condition, 
            // just use "validity" check as we only need to answer if the seq of length 3 exists or not
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
        Solution5DpConstSpace s = new Solution5DpConstSpace();
        boolean output = s.increasingTriplet(nums);
        boolean expected = true;
        boolean passed = output == expected;
        System.out.println("testSolution5Dp1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution5Dp2() {
        int[] nums = {5,4,3,2,1};
        Solution5DpConstSpace s = new Solution5DpConstSpace();
        boolean output = s.increasingTriplet(nums);
        boolean expected = false;
        boolean passed = output == expected;
        System.out.println("testSolution5Dp2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution5Dp3() {
        int[] nums = {2,1,5,0,4,6};
        Solution5DpConstSpace s = new Solution5DpConstSpace();
        boolean output = s.increasingTriplet(nums);
        boolean expected = true;
        boolean passed = output == expected;
        System.out.println("testSolution5Dp3: " + (passed ? "passed" : "failed"));
    }
}
