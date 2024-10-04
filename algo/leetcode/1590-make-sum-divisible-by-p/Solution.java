import java.util.HashMap;
class Solution {
    public int minSubarray(int[] nums, int p) {
        int rem_t = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            rem_t = (rem_t + nums[i])%p;
        }
        if (rem_t == 0) {
            return 0;
        }
        // rem[i] = longest prefix subseq with remainder = i
        HashMap<Integer, Integer> rems = new HashMap<>();
        rems.put(0, -1);
        int rem = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            rem = (rem + nums[i])%p;
            rems.put(rem, i);
            int search = (p + rem - rem_t)%p;
            if (rems.get(search) != null) {
                int cand = i+1-(rems.get(search)+1);
                if (cand != n) {
                    min = Math.min(min, i+1-(rems.get(search)+1));
                }
            }
        }
        return min != Integer.MAX_VALUE ? min : -1;
    }

    public static void main(String[] args) {
        test1();
        test71();
        test116();
    }

    public static void test1() {
        int[] nums = {3,1,4,2};
        int p = 6;
        int exp_output = 1;
        Solution sol = new Solution();
        int output = sol.minSubarray(nums, p);
        boolean passed = output == exp_output;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test116() {
        int[] nums = {8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2};
        int p = 148;
        int exp_output = 7;
        Solution sol = new Solution();
        int output = sol.minSubarray(nums, p);
        boolean passed = output == exp_output;
        System.out.println("test116: " + (passed ? "passed" : "failed"));
    }

    public static void test71() {
        int[] nums = {1,2,3};
        int p = 7;
        int exp_output = -1;
        Solution sol = new Solution();
        int output = sol.minSubarray(nums, p);
        boolean passed = output == exp_output;
        System.out.println("test71: " + (passed ? "passed" : "failed"));
    }
} 