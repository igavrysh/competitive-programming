package com.company;

import java.util.Stack;

public class SolutionPractice2 {
    public void reorderList(ListNode head) {
        ListNode node = head;

        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }

        Stack<ListNode> S = new Stack<>();
        node = head;
        int i = 0;
        int m = size%2==0 ? size/2 : size/2+1;
        while (node != null) {
            if (i>=m) {
                S.push(node);
            }
            node = node.next;
            i++;
        }
 
        node = head;
        while (node != null) {
            if (S.size() == 0) {
                node.next = null;
                node = node.next;
            }  else {
                ListNode stackHeadNode = S.pop();
                ListNode next = node.next;
                node.next = stackHeadNode;
                stackHeadNode.next = next;
                node = next;
            }
        }
    }
}


