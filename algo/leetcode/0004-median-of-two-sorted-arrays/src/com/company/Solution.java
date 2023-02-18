package com.company;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        boolean isMiddlePoint = totalLength % 2 == 0;
        int middlePoint = totalLength / 2 - 1 * (isMiddlePoint ? 1 : 0);
        int N1 = nums1.length;
        int N2 = nums2.length;

        int cursor1 = 0;
        int cursor2 = 0;

        double result = 0;

        while (cursor1 + cursor2 <= middlePoint + (isMiddlePoint ? 1 : 0)) {
            if (cursor2 == N2 || (cursor1 < N1 && cursor2 < N2 && nums1[cursor1] <= nums2[cursor2])) {
                if ((cursor1 + cursor2) == middlePoint
                        || (cursor1 + cursor2) == (middlePoint + 1)) {
                    result += nums1[cursor1];
                }
                cursor1 += 1;
            } else if (cursor1 == N1 || (cursor1 < N1 && cursor2 < N2 && nums1[cursor1] > nums2[cursor2])) {
                if ((cursor1 + cursor2) == middlePoint
                        || (cursor1 + cursor2) == (middlePoint + 1)) {
                    result += nums2[cursor2];
                }
                cursor2 += 1;
            }
        }
        return result / (isMiddlePoint ? 2.0 : 1.0);
    }
}