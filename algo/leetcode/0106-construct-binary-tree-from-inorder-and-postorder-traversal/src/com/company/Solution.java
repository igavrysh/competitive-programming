package com.company;

import java.util.HashMap;

public class Solution {
    private int[] inorder, postorder;
    private HashMap<Integer, Integer> inorderIdxes;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        inorderIdxes = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIdxes.put(inorder[i], i);
        }
        return gen(0, inorder.length, 0, postorder.length);
    }

    // inorderS - inclusive, inorderE - exclusive
    // postorderS - inclusive, postorderE - exclusive
    private TreeNode gen(int inorderS, int inorderE, int postorderS, int postorderE) {
        if (inorderS+1 == inorderE) {
            return new TreeNode(inorder[inorderS]);
        }

        int rootElem = postorder[postorderE-1];
        int rootElemInorderIdx = inorderIdxes.get(rootElem);
        
        int leftSize = rootElemInorderIdx - inorderS;
        int rightSize = inorderE - rootElemInorderIdx - 1;

        return new TreeNode(rootElem, 
            leftSize > 0 
            ? gen(
                inorderS, 
                inorderS+leftSize, 
                postorderS,
                postorderS+leftSize) 
            : null,
            rightSize>0
            ? gen(
                rootElemInorderIdx+1, 
                rootElemInorderIdx+1+rightSize, 
                postorderE-1-rightSize, 
                postorderE-1) 
            : null
        );
    }
}
