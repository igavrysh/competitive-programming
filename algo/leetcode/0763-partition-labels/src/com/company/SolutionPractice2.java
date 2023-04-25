package com.company;

import java.util.ArrayList;
import java.util.List;

public class SolutionPractice2 {

    public static void main(String[] args) {
        testSolutionPractice_1();
        testSolutionPractice_2();
    }

    public List<Integer> partitionLabels(String s) {
        int[] idx = new int[26];
        char[] chrs = s.toCharArray();
        for (int i = 0; i < chrs.length; i++) {
            idx[chrs[i]-'a'] = i;
        }
        int maxIdxSofar = -1;
        List<Integer> output = new ArrayList<>();
        int prevPos = -1;
        for (int i = 0; i < chrs.length; i++) {
            maxIdxSofar = Math.max(maxIdxSofar, idx[chrs[i]-'a']);
            if (maxIdxSofar == i) {
                output.add(i-prevPos);
                maxIdxSofar = -1;
                prevPos = i;
            }
        }
        return output;
    }

    public static void testSolutionPractice_1() {
        String input = "ababcbacadefegdehijhklij";
        SolutionPractice2 s = new SolutionPractice2();
        List<Integer> output = s.partitionLabels(input);
        boolean passed = output.size() == 3
            && output.get(0) == 9
            && output.get(1) == 7
            && output.get(2) == 8;
        System.out.println("testSolutionPractice_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice_2() {
        String input = "eccbbbbdec";
        SolutionPractice2 s = new SolutionPractice2();
        List<Integer> output = s.partitionLabels(input);
        boolean passed = output.size() == 1
            && output.get(0) == 10;
        System.out.println("testSolutionPractice_2: " + (passed ? "passed" : "failed"));
    }
}