package com.company;

class Main {
    public static void main(String[] args) {
        testMaxStackPQnDLinkedList1();
    }

    public static void testMaxStackPQnDLinkedList1() {
        MaxStackPQnDLinkedList s = new MaxStackPQnDLinkedList();
        s.push(5);
        s.push(1);
        s.push(5);
        boolean passed = true;
        passed = passed && s.top() == 5;
        passed = passed && s.popMax() == 5;
        passed = passed && s.top() == 1;
        passed = passed && s.peekMax() == 5;
        passed = passed && s.pop() == 1;
        passed = passed && s.top() == 5;
        System.out.println("testMaxStackPQnDLinkedList1: " + (passed ? "passed" : "failed"));
    }
}