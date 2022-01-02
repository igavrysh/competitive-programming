package com.company;

public class Solution {
  public int maxProduct(TreeNode root) {
    long totalSum = dfsSum(root);
    long[] maxProduct = {0};
    maxProductDfs(root, totalSum, maxProduct);
    long M = (long)(Math.pow(10, 9) + 7);
    return (int)(maxProduct[0] % M);
  }

  private long dfsSum(TreeNode node) {
    long sum = node.val;
    if (node.left != null) {
      sum += dfsSum(node.left);
    }
    if (node.right != null) {
      sum += dfsSum(node.right);
    }
    return sum;
  }

  private long maxProductDfs(TreeNode node, long totalSum, long[] maxProduct) {
    int leftSum = 0;
    if (node.left != null) {
      leftSum += maxProductDfs(node.left, totalSum, maxProduct);
    }
    if (maxProduct[0] < leftSum * (totalSum - leftSum)) {
      maxProduct[0] = leftSum * (totalSum - leftSum);
    }
    int rightSum = 0;
    if (node.right != null) {
      rightSum += maxProductDfs(node.right, totalSum, maxProduct);
    }
    if (maxProduct[0] < rightSum * (totalSum - rightSum)) {
      maxProduct[0] = rightSum * (totalSum - rightSum);
    }
    return node.val + leftSum + rightSum;
  }
}
