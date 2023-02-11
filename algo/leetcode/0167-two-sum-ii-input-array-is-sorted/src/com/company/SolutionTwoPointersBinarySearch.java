package com.company;

public class SolutionTwoPointersBinarySearch {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;
        while (l < r) {
            int sum = numbers[l]+numbers[r];
            if (sum==target) {
                return new int[]{l+1,r+1};
            }
            if (numbers[l]+numbers[r] < target) {
                int bsSum = numbers[l + (r-l)/2] + numbers[r];
                if (bsSum < target && (l+(r-l)/2) < r) {
                    l = l + (r-l)/2;
                } else {
                    l++;
                }

            }
            if (numbers[l]+numbers[r] > target) {
                int bsSum = numbers[l] + numbers[r - (r-l)/2];
                if (bsSum > target && (l<r-(r-l)/2) ) {
                    r = r - (r-l)/2;
                } else {
                    r--;
                }
            }
        }
        return null;
    }
}
