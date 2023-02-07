package com.company;

class SolutionTwoPointers {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;
        while (l < r) {
            if (numbers[l]+numbers[r]==target) {
                return new int[]{l+1,r+1};
            }
            if (numbers[l]+numbers[r] < target) {
                l++;
            }
            if (numbers[l]+numbers[r] > target) {
                r--;
            }
        }
        return null;
    }
}