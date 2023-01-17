package com.company;

import java.util.HashMap;
import java.util.Map;

// preorder - root(middle) first, left, right
// inorder - left first, middle, right
public class Solution3 {
    private int[] preorder;
    private Map<Integer, Integer> inorderIdxs;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        inorderIdxs = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIdxs.put(inorder[i], i);
        }

        return gen(0, preorder.length, 0, inorder.length);
    }

    // S - start, inclusive; E - end, exclusive
    private TreeNode gen(int preorderS, int preorderE, int inorderS, int inorderE) {
        if (preorderS == preorderE || inorderS == inorderE) {
            return null;
        }

        if (preorderS+1 == preorderE) {
            return new TreeNode(preorder[preorderS]);
        }
        
        int currentRoot = preorder[preorderS];
        int inoRootIdx = inorderIdxs.get(currentRoot);

        return new TreeNode(
            currentRoot, 
            gen(preorderS+1, preorderS+1 + (inoRootIdx-inorderS), inorderS, inoRootIdx),
            gen(preorderS+1 + (inoRootIdx-inorderS), preorderE, inoRootIdx+1, inorderE)
        ); 
    }    
}
