package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int distributeCoins(TreeNode root) {
        List<Integer> totalMoves = new ArrayList<>();
        totalMoves.add(0);
        DFS(root, totalMoves);
        return totalMoves.get(0);
    }

    private int DFS(TreeNode node, List<Integer> totalMoves) {
        if (node == null) {
            return 0;
        }

        int lCoins = DFS(node.left, totalMoves);
        int rCoins = DFS(node.right, totalMoves);

        int coinsToMoveUp = node.val + lCoins + rCoins - 1;
        totalMoves.set(0, totalMoves.get(0) + Math.abs(coinsToMoveUp));
        return coinsToMoveUp;
    }
}
