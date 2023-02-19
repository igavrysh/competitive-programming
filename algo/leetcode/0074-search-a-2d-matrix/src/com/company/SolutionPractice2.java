package com.company;

public class SolutionPractice2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int l = 0;
        int r = rows*cols-1;
        while (l <= r) {
            int m = l+(r-l)/2;
            int val = matrix[m/cols][m%cols];
            if (val == target) {
                return true;
            }
            if (target < val) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return false;
    }
}
