package com.company;

public class Main {
    public static void main(String[] args) {
        testSolutionHashMap1();
        testSolutionHashMap2();
        testSolutionProxyNodes1();
        testSolutionProxyNodes2();
    }

    public static void testSolutionHashMap1() {
        Node n7 = new Node(7), n13 = new Node(13), 
            n11 = new Node(11), n10 = new Node(10), 
            n1 = new Node(1);
        n7.next = n13; n13.next = n11;
        n11.next = n10; n10.next = n1;
        n7.random = null; n13.random = n7;
        n11.random = n1; n10.random = n11;
        n1.random = n7;
        Node head = n7;

        SolutionHashMap s = new SolutionHashMap();
        Node headCopy = s.copyRandomList(head);

        boolean passed = compareTwoList(head, headCopy);
        System.out.println("testSolutionHashMap1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionHashMap2() {
        Node n3_1 = new Node(3), n3_2 = new Node(3), n3_3 = new Node(3);
        n3_1.next = n3_2; n3_2.next = n3_3;
        n3_2.random = n3_1;
        Node head = n3_1;

        SolutionHashMap s = new SolutionHashMap();
        Node headCopy = s.copyRandomList(head);

        boolean passed = compareTwoList(head, headCopy);
        System.out.println("testSolutionHashMap2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionProxyNodes1() {
        Node n7 = new Node(7), n13 = new Node(13), 
            n11 = new Node(11), n10 = new Node(10), 
            n1 = new Node(1);
        n7.next = n13; n13.next = n11;
        n11.next = n10; n10.next = n1;
        n7.random = null; n13.random = n7;
        n11.random = n1; n10.random = n11;
        n1.random = n7;
        Node head = n7;

        SolutionProxyNodes s = new SolutionProxyNodes();
        Node headCopy = s.copyRandomList(head);

        boolean passed = compareTwoList(head, headCopy);
        System.out.println("testSolutionProxyNodes1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionProxyNodes2() {
        Node n3_1 = new Node(3), n3_2 = new Node(3), n3_3 = new Node(3);
        n3_1.next = n3_2; n3_2.next = n3_3;
        n3_2.random = n3_1;
        Node head = n3_1;

        SolutionProxyNodes s = new SolutionProxyNodes();
        Node headCopy = s.copyRandomList(head);

        boolean passed = compareTwoList(head, headCopy);
        System.out.println("testSolutionProxyNodes2: " + (passed ? "passed" : "failed"));
    }

    private static boolean compareTwoList(Node node, Node nodeCopy) {
        boolean passed = true;
        while (node != null) {
            passed = passed && (nodeCopy != null
                && node.val == nodeCopy.val
                && ((node.random == null && nodeCopy.random == null) 
                || (node.random != null && nodeCopy.random != null && node.random.val == nodeCopy.random.val))
            );
            node = node.next;
            if (nodeCopy == null) {
                passed = false;
                break;
            }
            nodeCopy = nodeCopy.next;
        }
        return passed;
    }
}