package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void test1() {
        Solution s = new Solution();
        List<Integer> out = s.grayCode(2);
        boolean passed = Arrays.equals(out.toArray(), new Integer[]{0,1,3,2})
                || Arrays.equals(out.toArray(), new Integer[]{0,2,3,1});
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        Solution s = new Solution();
        List<Integer> out = s.grayCode(3);
        boolean passed = Arrays.equals(out.toArray(), new Integer[]{0,1,3,2,6,7,5,4})
                || Arrays.equals(out.toArray(), new Integer[]{0,2,3,1});
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        Solution s = new Solution();
        List<Integer> out = s.grayCode(16);
        boolean passed = out.size() == (int)Math.pow(2, 16); 
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        System.out.println("Hello world!");
    }
}