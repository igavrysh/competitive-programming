class Solution {
    public int findMin(int[] nums) {
        return BS(0, nums.length-1, nums);
    }

    private int BS(int l, int r, int[] nums) {
        while (r-l > 1) {
            int m = l + (r-l)/2;

            if (nums[l] < nums[m] && nums[m] < nums[r]) {
                return nums[l];
            }

            if (nums[l] > nums[m] && nums[m] < nums[r]) {
                r = m;
                continue;
            }

            if (nums[l] < nums[m] && nums[m] > nums[r]) {
                l = m+1;
                continue;
            }

            int resL = BS(l, m, nums);
            int resR = BS(m+1, r, nums);
            return Math.min(resL, resR);

        }

        return Math.min(nums[l], nums[r]);
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