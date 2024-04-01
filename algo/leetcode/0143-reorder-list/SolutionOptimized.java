

public class SolutionOptimized {
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
        // find middle node and split list into two list
        ListNode middleNode = head, endNode = head;
        ListNode prevNode = null;
        while (endNode != null) {
            prevNode = middleNode;
            middleNode = middleNode.next;
            endNode = endNode.next;
            if (endNode != null) {
                endNode = endNode.next;
            }
        }
        if (prevNode != null) prevNode.next = null;

        // reverse the second list
        ListNode node = middleNode;
        prevNode = null;
        while (node != null) {
            ListNode nextNode = node.next;
            node.next = prevNode;
            prevNode = node;
            node = nextNode;
        }

        // merge two lists
        node = head;
        ListNode revNode = prevNode;
        while (revNode != null) {
            ListNode nextNode = node.next;
            ListNode nextRevNode = revNode.next;
            node.next = revNode;
            revNode.next = nextNode;
            node = nextNode;
            revNode = nextRevNode;
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
        SolutionOptimized s = new SolutionOptimized();
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
        SolutionOptimized s = new SolutionOptimized();
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
        SolutionOptimized s = new SolutionOptimized();
        s.reorderList(input);
        boolean passed = input.val == 1
                && input.next == null;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        ListNode input = null;
        SolutionOptimized s = new SolutionOptimized();
        s.reorderList(input);
        boolean passed = input == null;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }
}
