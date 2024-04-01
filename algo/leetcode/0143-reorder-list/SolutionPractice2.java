

import java.util.Stack;

public class SolutionPractice2 {
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
 
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        ListNode input = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))));
        SolutionPractice2 s = new SolutionPractice2();
        s.reorderList(input);
        boolean passed = input.val == 1
                && input.next.val == 4
                && input.next.next.val == 2
                && input.next.next.next.val == 3
                && input.next.next.next.next == null;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        ListNode input = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        SolutionPractice2 s = new SolutionPractice2();
        s.reorderList(input);
        boolean passed = input.val == 1
                && input.next.val == 5
                && input.next.next.val == 2
                && input.next.next.next.val == 4
                && input.next.next.next.next.val == 3
                && input.next.next.next.next.next == null;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        ListNode input = new ListNode(1, null);
        SolutionPractice2 s = new SolutionPractice2();
        s.reorderList(input);
        boolean passed = input.val == 1
                && input.next == null;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        ListNode input = null;
        SolutionPractice2 s = new SolutionPractice2();
        s.reorderList(input);
        boolean passed = input == null;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }
}


