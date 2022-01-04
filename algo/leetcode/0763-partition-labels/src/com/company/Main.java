package com.company;

import java.util.List;

public class Main {

    public static void test1() {
        String input = "ababcbacadefegdehijhklij";
        Solution s = new Solution();
        List<Integer> output = s.partitionLabels(input);
        boolean passed = output.size() == 3
            && output.get(0) == 9
            && output.get(1) == 7
            && output.get(2) == 8;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
	    test1();
    }
}
