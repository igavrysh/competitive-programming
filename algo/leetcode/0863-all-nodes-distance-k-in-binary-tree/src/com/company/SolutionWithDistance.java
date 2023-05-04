package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionWithDistance {

    private static class Pair<K, V> {
        public K key;
        public V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }
    }

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

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(target, 0));
        HashSet<Integer> seen = new HashSet<>();
        seen.add(target.val);
        List<Integer> output = new ArrayList<>();

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode n = p.getKey();
            int dist = p.getValue();
            if (dist == k) {
                output.add(n.val);
            } else if (dist < k) {
                List<TreeNode> adj = G.get(n.val);
                if (adj == null) {
                    continue;
                }
                for (TreeNode next : adj) {
                    if (!seen.contains(next.val)) {
                        queue.add(new Pair<>(next, dist + 1));
                        seen.add(next.val);
                    }
                }
            }
        }
        return output;
    }

}
