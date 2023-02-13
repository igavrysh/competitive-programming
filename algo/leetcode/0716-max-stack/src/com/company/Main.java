package com.company;

class Main {
    public static void main(String[] args) {
        testMaxStackPQnDLinkedList1();
        testMaxStackPQnDLinkedList2();
    }

    public static void testMaxStackPQnDLinkedList1() {
        MaxStack s = new MaxStack();
        s.Push(5);
        s.Push(1);
        s.Push(5);
        boolean passed = true;
        passed = passed && s.Top() == 5;
        passed = passed && s.PopMax() == 5;
        passed = passed && s.Top() == 1;
        passed = passed && s.PeekMax() == 5;
        passed = passed && s.Pop() == 1;
        passed = passed && s.Top() == 5;
        System.out.println("testMaxStackPQnDLinkedList1: " + (passed ? "passed" : "failed"));
    }

    public static void testMaxStackPQnDLinkedList2() {
        MaxStack s = new MaxStack();
        s.Push(5);
        boolean passed = true;
        passed = passed && s.PeekMax() == 5;
        passed = passed && s.PopMax() == 5;
        System.out.println("testMaxStackPQnDLinkedList2: " + (passed ? "passed" : "failed"));
    }
}