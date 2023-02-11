package com.company;

public class SolutionTwoPointersBS2 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l != r){
            int sum = numbers[l] + numbers[r];
            int mid = (l+r)/2;
            if (sum < target){
                if ((numbers[mid] + numbers[r]) <= target)
                    l = Math.max(mid, l+1);
                else
                    l++;
            }
            else if (sum > target){
                if ((numbers[l] + numbers[mid]) >= target)
                    r = mid;
                else
                    r--;
            }
            else if (sum == target){
                return new int[]{l+1,r+1};
            }
        }
        return null;
    }
}
