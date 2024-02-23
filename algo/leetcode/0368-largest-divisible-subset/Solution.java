import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] dp = new int[n][2];
        dp[0] = new int[]{1,0};
        int globalMaxLen = 1;
        int globalMaxEndIdx = 0; 
        for (int i = 1; i < n; i++) {
            int maxLen = 1;
            int maxFromIdx = i;
            for (int j = i-1; j>=0; j--) {
                if (nums[i]%nums[j] == 0 || nums[j]%nums[i] == 0) {
                    if (maxLen < dp[j][0]+1) {
                        maxLen = dp[j][0]+1;
                        maxFromIdx = j;
                    }
                }
            }
            dp[i] = new int[]{maxLen, maxFromIdx};
            if (maxLen > globalMaxLen) {
                globalMaxLen = maxLen;
                globalMaxEndIdx = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        int idx = globalMaxEndIdx;
        for (int i = globalMaxLen-1; i>=0; i--) {
            res.add(0, nums[idx]);
            idx = dp[idx][1];
        }
     
        return res;
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int[] nums = {1,2,3};
        int[] expOutputA = {1,2};
        Solution s = new Solution();
        List<Integer> output = s.largestDivisibleSubset(nums);
        List<Integer> expOutput = new ArrayList<>();
        for (int i = 0; i < expOutputA.length; i++) {
            expOutput.add(expOutputA[i]);
        }

        boolean passed = output.equals(expOutput);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }
}