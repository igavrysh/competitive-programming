package com.company;

public class SolutionNaive {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length;
        int N2 = nums2.length;
        int mid = (N1+N2)/2;
        int[] nums = new int[(N1+N2)/2];
        int n1 = 0; int n2 = 0;
        while (n1+n2 <= mid) {
            if (n2==N2 || (n1<nums1.length && n2<nums2.length && nums1[n1]<=nums2[n2])) {
                nums[n1+n2] = nums1[n1];
                n1++;
            } else if (n1==N1 || (n1<nums1.length && n2<nums2.length && nums1[n1]>nums2[n2])) {
                nums[n1+n2] = nums2[n2];
                n2++;
            }
        }
        return (N1+N2)%2==0 ? (nums[mid-1] + nums[mid])/2.0 : nums[mid];
    }
}
