package com.company;

import java.util.Arrays;
import java.util.List;

public class Solution {

  public double maximumAverageSubtree(TreeNode root) {
    // [maxAvg, sum, count]
    Double[] data = new Double[3];
    maxAvg(root, data);
    return data[0];
  }

  private void maxAvg(TreeNode node, Double[] data) {
    if (node.left == null && node.right == null) {
      data[0] = Double.valueOf(node.val);
      data[1] = Double.valueOf(node.val);
      data[2] = Double.valueOf(1);
      return;
    }

    double maxL = 0, sumL = 0, countL = 0;
    double maxR = 0, sumR = 0, countR = 0;

    if (node.left != null) {
      maxAvg(node.left, data);
      maxL = data[0];
      sumL = data[1];
      countL = data[2];
    }

    List<Integer> dataR = Arrays.asList(new Integer[]{0,0});
    if (node.right != null) {
      maxAvg(node.right, data);
      maxR = data[0];
      sumR = data[1];
      countR = data[2];
    }

    Double sum = node.val + sumL + sumR;
    Double count = 1 + countL + countR;
    double newMax = sum / count;
    data[0] = Math.max(Math.max(maxL, maxR), newMax);
    data[1] = sum;
    data[2] = count;
  }
}
