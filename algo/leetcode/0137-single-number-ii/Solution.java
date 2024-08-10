class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int j = 0;
            while (num != 0 && j < 32) {
                bits[j++] += (num & 1);
                num = num >> 1;
            }
        }
        int res = 0;
        for (int i = 31; i >= 0 ; i--) {
            if (bits[i]%3 == 0) {
                res = res << 1;
            } else {
                res = (res << 1) | 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        test2();
        test1();
    }

    private static void test1() {
        int[] nums = {2,2,3,2};
        int expOutput = 3;
        Solution sol = new Solution();
        int output = sol.singleNumber(nums);
        boolean passed = output == expOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    private static void test2() {
        int[] nums = {-2,-2,1,1,4,1,4,4,-4,-2};
        int expOutput = -4;
        Solution sol = new Solution();
        int output = sol.singleNumber(nums);
        boolean passed = output == expOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));       
    }
}