/*
 * Time Complexity: O(N^2) ~= 25 * 10^10 ~= 10^11
 * Space = O(1)
 */
public class Solution1BruteForce {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int n = nums.length;

        for (int i = 1; i < n-1; i++) {
            boolean leftMin = false;
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    leftMin = true;
                    break;
                }
      
            }
            if (!leftMin) {
                continue;
            }

            boolean rightMax = false;
            for (int k = i+1; k < n; k++) {
                if (nums[i] < nums[k]) {
                    rightMax = true;
                    break;
                }
            }

            if (leftMin && rightMax) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        testSolution1BruteForce1();
        testSolution1BruteForce2();
        testSolution1BruteForce3();
        testSolution1BruteForce4();
    }

    public static void testSolution1BruteForce1() {
        int[] nums = {1,2,3,4,5};
        Solution1BruteForce s = new Solution1BruteForce();
        boolean output = s.increasingTriplet(nums);
        boolean expected = true;
        boolean passed = output == expected;
        System.out.println("testSolutionBruteForce1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1BruteForce2() {
        int[] nums = {5,4,3,2,1};
        Solution1BruteForce s = new Solution1BruteForce();
        boolean output = s.increasingTriplet(nums);
        boolean expected = false;
        boolean passed = output == expected;
        System.out.println("testSolutionBruteForce2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1BruteForce3() {
        int[] nums = {2,1,5,0,4,6};
        Solution1BruteForce s = new Solution1BruteForce();
        boolean output = s.increasingTriplet(nums);
        boolean expected = true;
        boolean passed = output == expected;
        System.out.println("testSolutionBruteForce3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1BruteForce4() {
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        Solution1BruteForce s = new Solution1BruteForce();
        boolean output = s.increasingTriplet(nums);
        boolean expected = false;
        boolean passed = output == expected;
        System.out.println("testSolutionBruteForce4: " + (passed ? "passed" : "failed"));
    }
}