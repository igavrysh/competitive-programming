package leetcode.solutions;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length;
        int N2 = nums2.length;
        int N = N1 + N2;
        boolean isEvenN = N % 2 == 0;
        int m = N / 2 - 1 * (isEvenN ? 1 : 0);
        int i1 = 0;
        int i2 = 0;
        double acc = 0;
        while (i1 + i2 <= m + (isEvenN ? 1 : 0)) {
            if ((i1 < N1 && i2 < N2 && nums1[i1] <= nums2[i2])
                    || i2 == N2) {
                if ((i1 + i2) == m || (i1 + i2) == (m + 1)) {
                    acc += nums1[i1];
                }
                i1++;
            } else if ((i1 < N1 && i2 < N2 && nums1[i1] > nums2[i2])
                    || i1 == N1) {
                if ((i1 + i2) == m || (i1 + i2) == (m + 1)) {
                    acc += nums2[i2];
                }
                i2++;
            }
        }
        return acc / (isEvenN ? 2.0 : 1.0);
    }
}
// ------------------------------------------------------------