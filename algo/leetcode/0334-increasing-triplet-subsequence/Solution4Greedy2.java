public class Solution4Greedy2 {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length; 
        if (n < 3) {
            return false;
        }

        int minLeft = nums[0];
        int maxRight = nums[n-1];

        int j = n-1;
        for (int i = 1; i < n; i++) {
            if (i > j) {
                return false;
            }
            if (minLeft < nums[i]) {
                for (; j >= 1; j--) {
                    if (nums[j] < maxRight) {
                        if (i == j) {
                            return true;
                        } else if (i < j) {
                            break;
                        } else {
                            return false;
                        }
                    } else {
                        maxRight = nums[j];
                    }
                }
            }
            if (nums[i] > minLeft) {
                minLeft = nums[i];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        testSolution4Greedy2_1();
        testSolution3DpSuffixPrefixArrays2();
        testSolution3DpSuffixPrefixArrays3();
        testSolution3DpSuffixPrefixArrays4();
    }

    public static void testSolution4Greedy2_1() {
        int[] nums = {1,2,3,4,5};
        Solution4Greedy2 s = new Solution4Greedy2();
        boolean output = s.increasingTriplet(nums);
        boolean expected = true;
        boolean passed = output == expected;
        System.out.println("testSolution3DpSuffixPrefixArrays1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution3DpSuffixPrefixArrays2() {
        int[] nums = {5,4,3,2,1};
        Solution4Greedy2 s = new Solution4Greedy2();
        boolean output = s.increasingTriplet(nums);
        boolean expected = false;
        boolean passed = output == expected;
        System.out.println("testSolution3DpSuffixPrefixArrays1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution3DpSuffixPrefixArrays3() {
        int[] nums = {2,1,5,0,4,6};
        Solution4Greedy2 s = new Solution4Greedy2();
        boolean output = s.increasingTriplet(nums);
        boolean expected = true;
        boolean passed = output == expected;
        System.out.println("testSolution3DpSuffixPrefixArrays1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution3DpSuffixPrefixArrays4() {
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        Solution4Greedy2 s = new Solution4Greedy2();
        boolean output = s.increasingTriplet(nums);
        boolean expected = false;
        boolean passed = output == expected;
        System.out.println("testSolution3DpSuffixPrefixArrays1: " + (passed ? "passed" : "failed"));
    }
}