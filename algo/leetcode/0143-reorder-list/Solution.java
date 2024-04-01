

import java.util.Stack;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
    
        ListNode() {
        }
    
        ListNode(int val) {
            this.val = val;
        }
    
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void reorderList(ListNode head) {
        // to know the full length of the list
        int length = 0;
        ListNode n = head;
        while (n != null) {
            n = n.next;
            length++;
        }

        // to cut in half
        int m = length / 2;

        // add second half to a stack
        n = head;
        Stack<ListNode> stack = new Stack<>();
        int i = 0;
        while (n != null) {
            if (i >= m) {
                stack.push(n);
            }
            n = n.next;
            i++;
        }

        // go from the begining to the middle point, inserting elements from stack on
        // even places
        n = head;
        i = 0;
        while (n != null) {
            ListNode stackHead = stack.pop();
            ListNode tmp = stack.size() == 0 ? null : n.next;
            n.next = stackHead;
            stackHead.next = tmp;
            n = tmp;
            i++;
        }
    }
}
