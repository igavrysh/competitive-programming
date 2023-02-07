package com.company;

public class SolutionTwoLoops {
    public int[] twoSum(int[] numbers, int target) {
        int j = numbers.length-1;
        for (int i = 0; i < numbers.length; i++) {
            while (j > -1 && numbers[i]+numbers[j] > target) {
                j--;
            }
            if (numbers[i]+numbers[j] == target) {
                return new int[]{i+1,j+1};
            }
        }
        return null;
    }
}
