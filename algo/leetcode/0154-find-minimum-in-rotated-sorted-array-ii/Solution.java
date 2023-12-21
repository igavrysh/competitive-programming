public class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;

            // Can be skipped - small optimization for early exit
            if (nums[m] > nums[l] && nums[r] > nums[m]) {
                return nums[l];
            }

            if (nums[m] > nums[r]) {
                l = m + 1;
            } else if (nums[m] < nums[r]) {
                r = m;
            } else {
                r--;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        test4();
        test3();
        test1();
        test2();
    }

    public static void test1() {
        int[] nums = {1,3,5};
        int exepctedOutput = 1;
        Solution sol = new Solution();
        int output = sol.findMin(nums);
        boolean passed = output == exepctedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[] nums = {2,2,2,0,1};
        int exepctedOutput = 0;
        Solution sol = new Solution();
        int output = sol.findMin(nums);
        boolean passed = output == exepctedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int[] nums = {2,0,1,1,1};
        int exepctedOutput = 0;
        Solution sol = new Solution();
        int output = sol.findMin(nums);
        boolean passed = output == exepctedOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        int[] nums = {1,3,3};
        int exepctedOutput = 1;
        Solution sol = new Solution();
        int output = sol.findMin(nums);
        boolean passed = output == exepctedOutput;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }
}
