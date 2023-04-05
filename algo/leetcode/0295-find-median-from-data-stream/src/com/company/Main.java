package com.company;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();
        test3();

        testMedianFinderPractice2_1();
        testMedianFinderPractice2_2();
        testMedianFinderPractice2_3();
    }

    public static void test1() {
        boolean passed = true;
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        passed &= obj.findMedian() == 1.5;
        obj.addNum(3);
        passed &= obj.findMedian() == 2.0;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        boolean passed = true;
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        passed &= obj.findMedian() == 1;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        boolean passed = true;
        MedianFinder obj = new MedianFinder();

        for (int i = 1; i <= 1_000_000; i++) {
            obj.addNum(i);
        }
        double output = obj.findMedian();
        passed &= Math.abs(output - (500_000 + 500_001) / 2.0) < 0.00001;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void testMedianFinderPractice2_1() {
        boolean passed = true;
        MedianFinderPractice2 obj = new MedianFinderPractice2();
        obj.addNum(1);
        obj.addNum(2);
        passed &= obj.findMedian() == 1.5;
        obj.addNum(3);
        passed &= obj.findMedian() == 2.0;
        System.out.println("testMedianFinderPractice2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testMedianFinderPractice2_2() {
        boolean passed = true;
        MedianFinderPractice2 obj = new MedianFinderPractice2();
        obj.addNum(1);
        passed &= obj.findMedian() == 1;
        System.out.println("testMedianFinderPractice2_2: " + (passed ? "passed" : "failed"));
    }

    public static void testMedianFinderPractice2_3() {
        boolean passed = true;
        MedianFinderPractice2 obj = new MedianFinderPractice2();
        for (int i = 1; i <= 1_000_000; i++) {
            obj.addNum(i);
        }
        double output = obj.findMedian();
        passed &= Math.abs(output - (500_000 + 500_001) / 2.0) < 0.00001;
        System.out.println("testMedianFinderPractice2_3: " + (passed ? "passed" : "failed"));
    }
}
