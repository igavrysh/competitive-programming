package com.company;

import java.math.BigInteger;
import java.util.Arrays;

public class Main {

    public static int g1(int N) {
        int acc = 0;
        for (int i = N/2; i > 0; i/=2) {
            for (int j = 0; j < i; ++j) {
                acc++;
            }
        }
        return acc;
    }
    
    public static BigInteger g2(BigInteger N) {
        BigInteger acc = BigInteger.valueOf(0);
        for (BigInteger i = N.divide(BigInteger.TWO); i.compareTo(BigInteger.ZERO) != 0; i = i.divide(BigInteger.TWO)) {
            for (BigInteger j = BigInteger.ZERO; i.compareTo(j) == 1; j = j.add(BigInteger.ONE)) {
                acc = acc.add(BigInteger.ONE);
            }
        }
        return acc;
    }

    public static void main(String[] args) {
        int N = (int)Math.pow(2, 3);
        System.out.println("g1 N = " + N + ": " + g1(N));
        N = (int)Math.pow(2, 6);
        System.out.println("g1 N = " + N + ": " + g1(N));
        N = (int)Math.pow(2, 10);
        System.out.println("g1 N = " + N + ": " + g1(N));
        N = (int)Math.pow(2, 16);
        System.out.println("g1 N = " + N + ": " + g1(N));

        //System.out.println("g1 N = 1_000: " + g1(1000));
        //System.out.println("g1 N = 1_000_000: " + g1(1_000_000));
        
        //System.out.println("g2 N = 10: " + g2(new BigInteger("10")).toString());
        //System.out.println("g2 N = 100 " + g2(new BigInteger("100")).toString());
        //System.out.println("g2 N = 1_000: " + g2(new BigInteger("1000")).toString());
        //System.out.println("g2 N = 1_000_000: " + g2(new BigInteger("1000000")).toString());
        //System.out.println("g2 N = 1_000_000_000: " + g2(new BigInteger("1000000000")).toString());

        testSolutionNaive1();
        testSolutionNaive2();

        testSolutionPrefixSuffix1();
        testSolutionPrefixSuffix2();

        testSolutionPrefixSuffixInPlace1();
        testSolutionPrefixSuffixInPlace2();
        testSolutionPrefixSuffixInPlace3();
        testSolutionPrefixSuffixInPlace4();
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

    public static void testSolutionPrefixSuffixInPlace1() {
        SolutionPrefixSuffixInPlace s = new SolutionPrefixSuffixInPlace();
        int[] outputInt = s.productExceptSelf(new int[]{1,2,3,4});
        Integer[] output = new Integer[outputInt.length];
        for (int i=0; i<output.length; i++) {
            output[i] = outputInt[i];
        }
        boolean passed = Arrays.deepEquals(output, new Integer[]{24,12,8,6});
        System.out.println("testSolutionPrefixSuffixInPlace1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPrefixSuffixInPlace2() {
        SolutionPrefixSuffixInPlace s = new SolutionPrefixSuffixInPlace();
        int[] outputInt = s.productExceptSelf(new int[]{-1,1,0,-3,3});
        Integer[] output = new Integer[outputInt.length];
        for (int i=0; i<output.length; i++) {
            output[i] = outputInt[i];
        }
        boolean passed = Arrays.deepEquals(output, new Integer[]{0,0,9,0,0});
        System.out.println("testSolutionPrefixSuffixInPlace2: " + (passed ? "passed" : "failed"));       
    }

    public static void testSolutionPrefixSuffixInPlace3() {
        SolutionPrefixSuffixInPlace s = new SolutionPrefixSuffixInPlace();
        int[] outputInt = s.productExceptSelf(new int[]{1,2,3,4});
        Integer[] output = new Integer[outputInt.length];
        for (int i=0; i<output.length; i++) {
            output[i] = outputInt[i];
        }
        boolean passed = Arrays.deepEquals(output, new Integer[]{24,12,8,6});
        System.out.println("testSolutionPrefixSuffixInPlace3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPrefixSuffixInPlace4() {
        SolutionPrefixSuffixInPlace s = new SolutionPrefixSuffixInPlace();
        int[] outputInt = s.productExceptSelf(new int[]{-1,1,0,-3,3});
        Integer[] output = new Integer[outputInt.length];
        for (int i=0; i<output.length; i++) {
            output[i] = outputInt[i];
        }
        boolean passed = Arrays.deepEquals(output, new Integer[]{0,0,9,0,0});
        System.out.println("testSolutionPrefixSuffixInPlace4: " + (passed ? "passed" : "failed"));       
    }
}