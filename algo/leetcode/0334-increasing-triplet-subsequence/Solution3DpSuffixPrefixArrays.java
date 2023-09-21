/*
Time complexity: O(N)
Space complexity: O(N)
 */

public class Solution3DpSuffixPrefixArrays {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length; 
        if (n < 3) {
            return false;
        }

        int[] dpMinLeft = new int[n];
        int[] dpMaxRight = new int[n];
        int minLeft = nums[0];
        int maxRight = nums[n-1];

        for (int i = 1; i < n; i++) {
            if (nums[i-1] < minLeft) {
                minLeft = nums[i-1];
            }
            dpMinLeft[i] = minLeft;

            if (nums[n-i] > maxRight) {
                maxRight = nums[n-i];
            }
            dpMaxRight[n-1-i] = maxRight;
        }

        for (int i = 1; i < n-1; i++) {
            if (dpMinLeft[i] < nums[i] && nums[i] < dpMaxRight[i]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        testSolution3DpSuffixPrefixArrays1();
        testSolution3DpSuffixPrefixArrays2();
        testSolution3DpSuffixPrefixArrays3();
        testSolution3DpSuffixPrefixArrays4();
    }

    public static void testSolution3DpSuffixPrefixArrays1() {
        int[] nums = {1,2,3,4,5};
        Solution3DpSuffixPrefixArrays s = new Solution3DpSuffixPrefixArrays();
        boolean output = s.increasingTriplet(nums);
        boolean expected = true;
        boolean passed = output == expected;
        System.out.println("testSolution3DpSuffixPrefixArrays1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution3DpSuffixPrefixArrays2() {
        int[] nums = {5,4,3,2,1};
        Solution3DpSuffixPrefixArrays s = new Solution3DpSuffixPrefixArrays();
        boolean output = s.increasingTriplet(nums);
        boolean expected = false;
        boolean passed = output == expected;
        System.out.println("testSolution3DpSuffixPrefixArrays1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution3DpSuffixPrefixArrays3() {
        int[] nums = {2,1,5,0,4,6};
        Solution3DpSuffixPrefixArrays s = new Solution3DpSuffixPrefixArrays();
        boolean output = s.increasingTriplet(nums);
        boolean expected = true;
        boolean passed = output == expected;
        System.out.println("testSolution3DpSuffixPrefixArrays1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution3DpSuffixPrefixArrays4() {
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        Solution3DpSuffixPrefixArrays s = new Solution3DpSuffixPrefixArrays();
        boolean output = s.increasingTriplet(nums);
        boolean expected = false;
        boolean passed = output == expected;
        System.out.println("testSolution3DpSuffixPrefixArrays1: " + (passed ? "passed" : "failed"));
    }
}
