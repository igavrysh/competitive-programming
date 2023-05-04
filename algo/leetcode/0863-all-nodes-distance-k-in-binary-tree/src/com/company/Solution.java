package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    private List<TreeNode> getOrCreate(HashMap<Integer, List<TreeNode>> G, int v) {
        if (G.get(v) != null) {
            return G.get(v);
        }

        List<TreeNode> l = new ArrayList<>();
        G.put(v, l);
        return l;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<Integer, List<TreeNode>> G = new HashMap<>();

        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while (!Q.isEmpty()) {
            TreeNode n = Q.poll();
            TreeNode l = n.left;
            TreeNode r = n.right;
            if (l != null) {
                getOrCreate(G, l.val).add(n);
                getOrCreate(G, n.val).add(l);
                Q.add(l);
            }
            if (r != null) {
                getOrCreate(G, r.val).add(n);
                getOrCreate(G, n.val).add(r);
                Q.add(r);
            }
        }

        int level = 0;
        Q = new LinkedList<>();
        Q.add(target);
        HashSet<Integer> seen = new HashSet<>();
        seen.add(target.val);
        while (!Q.isEmpty()) {
            if (level == k) {
                break;
            }

            int levelSize = Q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode n = Q.poll();
                List<TreeNode> adj = G.get(n.val);
                if (adj == null) {
                    continue;
                }

                for (TreeNode next : adj) {
                    if (!seen.contains(next.val)) {
                        Q.add(next);
                        seen.add(next.val);
                    }
                }
            }
            level++;
        }

        List<Integer> output = new ArrayList<>();
        while (!Q.isEmpty()) {
            output.add(Q.poll().val);
        }
        return output;
    }

}
