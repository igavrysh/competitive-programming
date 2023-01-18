package com.company;

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] globalMax = new int[1];
        globalMax[0] = Integer.MIN_VALUE;
        dfs(root, globalMax);
        return globalMax[0];
    }

    private int dfs(TreeNode node, int[] globalMax) {
        if (node.left == null && node.right == null) {
            if (globalMax[0] < node.val) {
                globalMax[0] = node.val;
            }
            return node.val;
        }

        Integer maxL = node.left != null ? dfs(node.left, globalMax) : null;
        Integer maxR = node.right != null ? dfs(node.right, globalMax) : null;

        if (maxL!=null && maxR!=null && maxL+maxR+node.val>globalMax[0]) {
            globalMax[0] = maxL+maxR+node.val ;
        }

        if (maxL!=null && maxL+node.val>globalMax[0]) {
            globalMax[0] = maxL+node.val;
        }

        if (maxR!=null && maxR+node.val>globalMax[0]) {
            globalMax[0] = maxR+node.val;
        }

        if (node.val>globalMax[0]) {
            globalMax[0] = node.val;
        }
        
        return Collections.max(Arrays.asList(new Integer[] {
            maxL!=null ? (maxL + node.val) : Integer.MIN_VALUE, 
            maxR!=null ? (maxR + node.val) : Integer.MIN_VALUE,
            node.val
        }));
    }
}