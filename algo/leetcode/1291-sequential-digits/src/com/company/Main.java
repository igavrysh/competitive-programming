package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static void test1() {
        Solution s = new Solution();
        List<Integer> output = s.sequentialDigits(100, 300);
        boolean passed = output.size() == 2
            && output.contains(123)
            && output.contains(234);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    private static void test2() {
        Solution s = new Solution();
        List<Integer> output = s.sequentialDigits(1000, 13000);
        //Collections.sort(output);
        Integer[] arr = output.toArray(new Integer[0]);
        boolean passed = output.size() == 7
            && Arrays.equals(arr, new Integer[]{1234,2345,3456,4567,5678,6789,12345});
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
