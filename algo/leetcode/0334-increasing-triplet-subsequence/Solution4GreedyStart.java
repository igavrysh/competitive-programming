/*
Time complexity: O(N)
Space complexity: O(N)
*/

public class Solution4GreedyStart {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length; 
        if (n < 3) {
            return false;
        }

        boolean[] marked = new boolean[n];

        int minLeft = nums[0];

        for (int i = 1; i < n; i++) {
            if (minLeft < nums[i]) {
                marked[i] = true;
            }

            if (minLeft > nums[i]) {
                minLeft = nums[i];
            }
        }

        int maxRight = nums[n-1];
        for (int i = n-2; i >= 1; i--) {
            if (maxRight > nums[i] && marked[i]) {
                return true;
            }

            if (maxRight < nums[i]) {
                maxRight = nums[i];
            }
        }

        return false;
    }
}