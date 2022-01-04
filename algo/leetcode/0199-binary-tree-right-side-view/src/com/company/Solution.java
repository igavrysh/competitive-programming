package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> currLevel = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        currLevel.offer(root);
        List<Integer> output = new ArrayList<>();

        while (currLevel.size() != 0) {
            int currLevelSize = currLevel.size();
            output.add(((LinkedList<TreeNode>) currLevel).getLast().val);
            while (currLevelSize > 0) {
                TreeNode tn = currLevel.poll();
                if (tn.left != null) {
                    currLevel.offer(tn.left);
                }
                if (tn.right != null) {
                    currLevel.offer(tn.right);
                }
                currLevelSize--;
            }
        }

        return output;
    }
}
