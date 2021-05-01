package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> output = new ArrayList<>();
    int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int d = 0;
    int currI = 0;
    int currJ = -1;
    int w = matrix[0].length;
    int h = matrix.length-1;
    int counter = 0;
    for (int s = 0; s < matrix.length * matrix[0].length; s++) {
      currI += D[d][0];
      currJ += D[d][1];
      output.add(matrix[currI][currJ]);
      counter++;
      if (counter == (d % 2 == 0 ? w : h)) {
        if (d % 2 == 0) {
          w--;
        } else {
          h--;
        }
        d = (d + 1) % 4;
        counter = 0;
      }
    }
    return output;
  }
}
