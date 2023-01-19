package com.company;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> l = new ArrayList<>();
        while (head != null) {
            l.add(head.val);
            head = head.next;
        }
        return tree(0, l.size(), l);
    }

    // s - start inclusive, e - end exclusive
    private TreeNode tree(int s, int e, List<Integer> l) {
        if (s+1 == e) {
            return new TreeNode(l.get(s));
        }

        int m = s+(int)((e-s)/2.0);

        TreeNode n = new TreeNode(
            l.get(m),
            s < m ? tree(s, m, l) : null,
            m+1 < e ? tree(m+1, e, l) : null);
        return n;
    }
}