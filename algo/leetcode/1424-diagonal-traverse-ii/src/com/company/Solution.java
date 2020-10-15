package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public int[] findDiagonalOrder(List<List<Integer>> nums) {
    List<Integer> output = new ArrayList<>();
    int mLength = 0;
    int totalSize = 0;
    for (int i = 0; i < nums.size(); i++) {
      if (mLength < nums.get(i).size()) {
        mLength = nums.get(i).size();
      }
      totalSize += nums.get(i).size();
    }
    int[][] DM = new int[nums.size()][mLength];
    for (int i = 0; i < DM.length; i++) {
      for (int j = 0; j < DM[i].length; j++) {
        DM[i][j] = i-1 >= 0 && j+1 < DM[i-1].length
            ? DM[i-1][j+1] + (nums.get(i-1).size() > j+1 ? 1 : 0)
            : 0;
      }
    }
    int D = nums.size() + mLength-1;
    int[] ans = new int[totalSize];
    int idx = 0;
    for (int diag = 0; diag < D; diag++) {
      int icap = diag > (nums.size()-1) ? nums.size()-1 : diag;
      int offset = diag - icap;
      for (int i = icap; i >= 0; i--) {
        int j = diag - i;

        if (i >= 0 && i < nums.size() &&
            j >= 0 && j < nums.get(i).size()
        ) {
          ans[idx++] = nums.get(i).get(j);
          //output.add(nums.get(i).get(j));
         // System.out.print("<i:"+i+" j:"+j+">");
          if (DM[i][j] == 0) {
            break;
          }
        }
      }
      //System.out.print("\n");
    }

    return ans;
  }
}
