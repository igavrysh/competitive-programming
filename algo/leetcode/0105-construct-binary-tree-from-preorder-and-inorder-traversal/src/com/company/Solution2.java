package com.company;

import java.util.Arrays;

public class Solution2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        
        int currentRoot = preorder[0];
        int inoRootIdx = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == currentRoot) {
                inoRootIdx = i;
                break;
            }
        }

        return new TreeNode(
            currentRoot, 
            buildTree(
                Arrays.copyOfRange(preorder, 1, inoRootIdx+1), 
                Arrays.copyOfRange(inorder, 0, inoRootIdx)
            ), 
            buildTree(
                Arrays.copyOfRange(preorder, inoRootIdx+1, inorder.length),
                Arrays.copyOfRange(inorder, inoRootIdx+1, inorder.length)
            )
        );
    }
}
