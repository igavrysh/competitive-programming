class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] seq = new int[nums.length];
        for (int i = 0; i < seq.length; i++) {
            seq[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            int lMax = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lMax < seq[j] + 1) {
                    lMax = seq[j] + 1;
                }
            }
            seq[i] = lMax;
        }
        int output = seq[0];
        for (int i = 0; i < seq.length; i++) {
            if (output < seq[i]) {
                output = seq[i];
            }
        }
        return output;
    }


    public static void test1() {
        Solution s = new Solution();
        int output = s.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 });
        boolean passed = output == 4;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        Solution s = new Solution();
        int output = s.lengthOfLIS(new int[] {});
        boolean passed = output == 0;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        Solution s = new Solution();
        int output = s.lengthOfLIS(new int[] { 5 });
        boolean passed = output == 1;
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}