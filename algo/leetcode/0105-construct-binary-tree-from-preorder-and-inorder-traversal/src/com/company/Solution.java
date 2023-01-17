package com.company;

import java.util.Arrays;

class Solution {
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

        int[] inorderLeft = inoRootIdx > 0 ?
            Arrays.copyOfRange(inorder, 0, inoRootIdx) 
            : null;
        int[] inorderRight = inorder.length-inoRootIdx-1 > 0 
            ? Arrays.copyOfRange(inorder, inoRootIdx+1, inorder.length) 
            : null; 

        int[] preoLeft = inoRootIdx>0 ? Arrays.copyOfRange(preorder, 1, inoRootIdx+1) : null;
        int[] preoRight = inoRootIdx < inorder.length-1 ?  Arrays.copyOfRange(preorder, inoRootIdx+1, inorder.length) : null;

        return new TreeNode(currentRoot,
            preoLeft != null && inorderLeft != null ? buildTree(preoLeft, inorderLeft) : null,
            preoRight != null && inorderRight != null ? buildTree(preoRight, inorderRight) : null
        );
    }    
}