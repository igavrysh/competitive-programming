package com.company;

import com.company.RandomizedSet.Element;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();
        test3();

        testPractice2_1();
        testPractice2_3();
        testPractice2_4();
    }

    public static void test1() {
        boolean passed = true;
        RandomizedSet s = new RandomizedSet();
        passed = passed && s.insert(1);
        System.out.println("test1: insert 1 " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        passed = passed && !s.remove(2);
        System.out.println("test1: remove 2 " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        passed = passed && s.insert(2);
        System.out.println("test1: insert 2 " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        int rV = s.getRandom();
        passed = passed && (rV == 1 || rV == 2);
        System.out.println("test1: get Random " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        passed = passed && s.remove(1);
        System.out.println("test1: remove 1 " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        passed = passed && !s.insert(2);

        System.out.println("test1: insert 2 " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        passed = passed && s.getRandom() == 2;

        System.out.println("test1: getRandom " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        RandomizedSet s = new RandomizedSet();
        boolean passed = s.insert(1);
        passed = passed && s.list.size() == 1 && s.map.size() == 1;
        passed = passed && s.getRandom() == 1;
        Element e = s.map.get(1);
        passed = passed && e.indexInList == 0;
        passed = passed && e.value == 1;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        boolean passed = true;
        RandomizedSet s = new RandomizedSet();
        passed = passed && s.insert(0);
        System.out.println("test3: insert 1 " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        passed = passed && s.insert(1);
        System.out.println("test3: insert 1 " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        passed = passed && s.remove(0);
        System.out.println("test3: remove 0 " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        passed = passed && s.insert(2);
        System.out.println("test3: insert 2 " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        passed = passed && s.remove(1);
        System.out.println("test3: remove 1 " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        passed = passed && s.getRandom() == 2;

        System.out.println("test3: getRandom " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }


    public static void testPractice2_1() {
        boolean passed = true;
        RandomizedSetPractice2 s = new RandomizedSetPractice2();
        passed = passed && s.insert(1);
        System.out.println("testPractice2_1: insert 1 " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        passed = passed && !s.remove(2);
        System.out.println("test1: remove 2 " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        passed = passed && s.insert(2);
        System.out.println("test1: insert 2 " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        int rV = s.getRandom();
        passed = passed && (rV == 1 || rV == 2);
        System.out.println("test1: get Random " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        passed = passed && s.remove(1);
        System.out.println("test1: remove 1 " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        passed = passed && !s.insert(2);

        System.out.println("test1: insert 2 " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        passed = passed && s.getRandom() == 2;

        System.out.println("test1: getRandom " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void testPractice2_3() {
        boolean passed = true;
        RandomizedSetPractice2 s = new RandomizedSetPractice2();
        passed = passed && s.insert(0);
        System.out.println("testPractice2_3: insert 1 " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        passed = passed && s.insert(1);
        System.out.println("testPractice2_3: insert 1 " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        passed = passed && s.remove(0);
        System.out.println("testPractice2_3: remove 0 " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        passed = passed && s.insert(2);
        System.out.println("testPractice2_3: insert 2 " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        passed = passed && s.remove(1);
        System.out.println("testPractice2_3: remove 1 " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        passed = passed && s.getRandom() == 2;

        System.out.println("testPractice2_3: getRandom " + (passed ? "passed" : "failed"));
        if (!passed) {
            return;
        }

        System.out.println("testPractice2_3: " + (passed ? "passed" : "failed"));
    }

    public static void testPractice2_4() {
        String[] ops = {"RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"};
        Integer[][] args = {{},{-1},{-2},{-2},{},{-1},{-2},{}};

        RandomizedSetPractice2 set = null;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("RandomizedSet")) {
                set = new RandomizedSetPractice2();
            } else if (ops[i].equals("insert")) {
                set.insert(args[i][0]);
            } else if (ops[i].equals("remove")) {
                set.remove(args[i][0]);
            } else if (ops[i].equals("getRandom")) {
                set.getRandom();
            }
        } 
    }
}
