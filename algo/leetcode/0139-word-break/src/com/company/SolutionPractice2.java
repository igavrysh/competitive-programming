package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SolutionPractice2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> words = new HashSet<>(wordDict);
        int n = s.length();
        List<Integer> DP = new ArrayList<>();
        DP.add(-1);
        for (int i = 0; i < n; i++) {
            for (int j = DP.size()-1; j >= 0; j--) {
                String sbs = s.substring(DP.get(j)+1, i+1);
                if (words.contains(sbs)) {
                    DP.add(i);
                    break;
                }
            }
        }
        return DP.get(DP.size()-1) == s.length()-1;
    }

    public static void main(String[] args) {
        testSolutionPractice2_1();
        testSolutionPractice2_2();
        testSolutionPractice2_3();
    }

    private static void testSolutionPractice2_1() {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>() {{ add("leet"); add("code"); }};
        SolutionPractice2 sol = new SolutionPractice2(); 
        boolean output = sol.wordBreak(s, wordDict);
        boolean passed = output == true;
        System.out.println("testSolutionPractice2_1: " + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2_2() {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>() {{ add("apple"); add("pen"); }};
        SolutionPractice2 sol = new SolutionPractice2(); 
        boolean output = sol.wordBreak(s, wordDict);
        boolean passed = output == true;
        System.out.println("testSolutionPractice2_2: " + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2_3() {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>() {{ 
            add("cats"); 
            add("dog"); 
            add("sand");
            add("and");
            add("cat");
        }};
        SolutionPractice2 sol = new SolutionPractice2(); 
        boolean output = sol.wordBreak(s, wordDict);
        boolean passed = output == false;
        System.out.println("testSolutionPractice2_3: " + (passed ? "passed" : "failed"));
    }
}
