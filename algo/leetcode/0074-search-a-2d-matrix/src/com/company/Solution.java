package com.company;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int nCols = matrix[0].length;
        int nRows = matrix.length;
        int l = 0;
        int r = nRows - 1;
        int m = 0;
        while (l < r) {
            m = l + (r - l) / 2;
            if (matrix[l][0] <= target && matrix[m][nCols - 1] >= target) {
                r = m;
            } else if (m + 1 < nRows && matrix[m + 1][0] <= target && matrix[r][nCols - 1] >= target) {
                l = m + 1;
            } else {
                return false;
            }
        }
        int M = l;
        l = 0;
        r = nCols - 1;
        while (l < r) {
            m = l + (r - l) / 2;
            if (matrix[M][m] == target) {
                return true;
            }
            if (matrix[M][l] <= target && matrix[M][m] > target) {
                r = m;
            } else if (matrix[M][m] < target && matrix[M][r] >= target) {
                l = m + 1;
            } else {
                return false;
            }
        }
        return M < nRows && l < nCols && matrix[M][l] == target;
    }
}
