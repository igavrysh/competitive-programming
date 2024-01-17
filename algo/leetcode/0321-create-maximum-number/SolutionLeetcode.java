class SolutionLeetcode {

/*
nums1
0                                       499
0 0 0 0 0 0 0 ... 0 1 0 ... 0 0 0 0 0 0 0 0

nums2
0                                       499
0 0 0 0 0 0 0 ... 0 1 0 ... 0 0 0 0 0 0 0 0

k = 500\


 */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, ans, 0)) ans = candidate;
        }
        return ans;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r)
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return ans;
    }

    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
/*

9

25 25                                       25

9999 8888 77777 66666 55555 44444 3333 2222 111 push 2222

9999 8888 77777 66666 55555 44444 3333 2222 2222 push 3333

9999 8888 77777 66666 55555 44444 3333 3333   push 444




n / 9

stack size = n / 2
ops = n/2

push 2s: 
stack size = n / 2 , 
ops: pop n / 9 / 2, push n/9/2

push 3s:
stack size = n/2 - n/2/9
ops: pop n/9/2 x 2, push n/9/2

push 4s:

*/
    public int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; ++i) {
            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
            if (j < k) ans[j++] = nums[i];
        }
        return ans;
    }
}