package com.company;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        return searchInternal(0, nums.length - 1, nums, target);
    }

    private int searchInternal(int l, int r, int[] nums, int target) {
        int result = -1;
        if (l == r) {
            return nums[l] == target ? l : -1;
        }

        int mP = (l + r) / 2;
        if (nums[l] <= nums[mP] && target >= nums[l] && target <= nums[mP]) {
            result = binarySearch(l, mP, nums, target);
        }
        if (result == -1 && nums[l] > nums[mP] && (target >= nums[l] || target <= nums[mP])) {
            result = searchInternal(l, mP, nums, target);
        }
        if (result == -1 && nums[mP + 1] <= nums[r] && target >= nums[mP + 1] && target <= nums[r]) {
            result = binarySearch(mP + 1, r, nums, target);
        }
        if (result == -1 && nums[mP + 1] > nums[r] && (target >= nums[mP + 1] || target <= nums[r])) {
            result = searchInternal(mP + 1, r, nums, target);
        }
        return result;
    }

    private int binarySearch(int l, int r, int[] nums, int target) {
        if (l > r || l < 0 || r >= nums.length) {
            return -1;
        }
        if (nums[r] < target || nums[l] > target) {
            return -1;
        }
        if (l == r) {
            if (nums[l] == target) {
                return l;
            }
            return -1;
        }
        int mP = (l + r) / 2;
        if (nums[mP] > target) {
            return binarySearch(l, mP - 1, nums, target);
        }
        if (nums[mP] < target) {
            return binarySearch(mP + 1, r, nums, target);
        }
        return mP;
    }
}
