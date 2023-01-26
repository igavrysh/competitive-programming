package com.company;

import java.util.Arrays;

public class Main {
    
    public static int g(int N) {
        int acc = 0;
        for (int i = N/2; i > 0; i /= 2) {
            for (int j = 0; j < i; ++j) {
                acc++;
            }
        }
        return acc;
    }

    public static void main(String[] args) {
        /* 
        System.out.println("N = 10: " + g(10));
        System.out.println("N = 100: " + g(100));
        System.out.println("N = 1000: " + g(1000));
        System.out.println("N = 10000: " + g(10000));
        System.out.println("N = 1_000_000_000: " + g(1_000_000_000));
        */

        testSolutionNaive1();
        testSolutionNaive2();

        testSolutionPrefixSuffix1();
        testSolutionPrefixSuffix2();
    }

    public static void testSolutionNaive1() {
        SolutionNaive s = new SolutionNaive();
        int[] outputInt = s.productExceptSelf(new int[]{1,2,3,4});
        Integer[] output = new Integer[outputInt.length];
        for (int i=0; i<output.length; i++) {
            output[i] = outputInt[i];
        }
        boolean passed = Arrays.deepEquals(output, new Integer[]{24,12,8,6});
        System.out.println("testSolutionNaive1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionNaive2() {
        SolutionNaive s = new SolutionNaive();
        int[] outputInt = s.productExceptSelf(new int[]{-1,1,0,-3,3});
        Integer[] output = new Integer[outputInt.length];
        for (int i=0; i<output.length; i++) {
            output[i] = outputInt[i];
        }
        boolean passed = Arrays.deepEquals(output, new Integer[]{0,0,9,0,0});
        System.out.println("testSolutionNaive2: " + (passed ? "passed" : "failed"));       
    }

    public static void testSolutionPrefixSuffix1() {
        SolutionPrefixSuffix s = new SolutionPrefixSuffix();
        int[] outputInt = s.productExceptSelf(new int[]{1,2,3,4});
        Integer[] output = new Integer[outputInt.length];
        for (int i=0; i<output.length; i++) {
            output[i] = outputInt[i];
        }
        boolean passed = Arrays.deepEquals(output, new Integer[]{24,12,8,6});
        System.out.println("testSolutionPrefixSuffix1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPrefixSuffix2() {
        SolutionPrefixSuffix s = new SolutionPrefixSuffix();
        int[] outputInt = s.productExceptSelf(new int[]{-1,1,0,-3,3});
        Integer[] output = new Integer[outputInt.length];
        for (int i=0; i<output.length; i++) {
            output[i] = outputInt[i];
        }
        boolean passed = Arrays.deepEquals(output, new Integer[]{0,0,9,0,0});
        System.out.println("testSolutionPrefixSuffix2: " + (passed ? "passed" : "failed"));       
    }   
}