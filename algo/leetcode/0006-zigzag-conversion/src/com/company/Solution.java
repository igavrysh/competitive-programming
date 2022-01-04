package com.company;

public class Solution {
  public String convert(String s, int numRows) {
    char[][] matrix = new char[numRows][s.length()];
    int sIdx = 0;
    int currentCol = 0;
    int currentRow = 0;
    while (sIdx < s.length()) {
      for (int row = currentRow; row < currentRow + numRows; row++) {
        if (sIdx >= s.length()) {
          break;
        }
        matrix[row][currentCol]= s.charAt(sIdx++);
      }

      currentRow = currentRow + (numRows == 1 ? numRows : (numRows-1)) - 1;
      int row = currentRow;
      for (int col = currentCol+1; col < currentCol + numRows - 1; col++) {
        if (sIdx >= s.length()) {
          break;
        }
        matrix[row][col] = s.charAt(sIdx++);
        row -= 1;
      }
      currentCol = currentCol + (numRows == 1 ? 1 : (numRows-1));
      currentRow = 0;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] != 0) {
          sb.append(matrix[i][j]);
        }
      }
    }
    return sb.toString();
  }

  private void print(char[][] matrix) {
    for (int i1 = 0; i1 < matrix.length; i1++) {
      for (int i2 = 0; i2 < matrix[0].length; i2++) {
        if (matrix[i1][i2] == 0) {
          System.out.print(' ');
        }
        System.out.print(matrix[i1][i2]);
      }
      System.out.println();
    }
  }
}
