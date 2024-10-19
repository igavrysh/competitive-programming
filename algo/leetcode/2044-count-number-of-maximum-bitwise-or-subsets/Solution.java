import java.util.HashMap;

public class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int[] max = new int[]{-1};
        HashMap<Integer, Integer> fq = new HashMap<>();
        BT(0, fq, nums, max);
        return fq.get(max[0]);
    }
    private void BT(int pos, HashMap<Integer, Integer> fq, int[] nums, int[] max) {
        if (pos >= nums.length) {
            return;
        }
        int num = nums[pos];
        HashMap<Integer, Integer> to_add = new HashMap<>();
        for (int val : fq.keySet()) {
            int new_val = val | num;
            to_add.put(new_val, to_add.getOrDefault(new_val,0) + fq.get(val));
        }
        to_add.put(num, to_add.getOrDefault(num, 0)+1);
        for (int key : to_add.keySet()) {
            fq.put(key, to_add.get(key) + fq.getOrDefault(key, 0));
            if (max[0] == -1 || fq.get(max[0]) < fq.get(key)) {
                max[0] = key;
            }
        }
        BT(pos+1, fq, nums, max);
    }
    public static void main(String[] args) {
        test1();
        test3();
    }
    public static void test3() {
        int[] nums = {3,2,1,5};
        int exp_output = 6;
        Solution sol = new Solution();
        int output = sol.countMaxOrSubsets(nums);
        boolean passed = output == exp_output;
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    } 

    public static void test1() {
        int[] nums = {2,2,2};
        int exp_output = 7;
        Solution sol = new Solution();
        int output = sol.countMaxOrSubsets(nums);
        boolean passed = output == exp_output;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }
}