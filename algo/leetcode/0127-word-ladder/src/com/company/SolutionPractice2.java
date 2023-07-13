package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class SolutionPractice2 {

    private String mask(int i, String s) {
        return s.substring(0, i) + "*" + s.substring(i+1, s.length());
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 0;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String mask = mask(i, word);
                List<String> l = map.getOrDefault(mask, new ArrayList<>());
                l.add(word);
                map.put(mask, l);
            }
        }

        boolean found = false;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(endWord)) {
                found = true;
                break;
            }
        }
        if (!found) {
            return 0;
        }

        Queue<String> qB = new ArrayDeque<>();
        Queue<String> qE = new ArrayDeque<>();
        qB.add(beginWord);
        qE.add(endWord);
        HashSet<String> beginSet = new HashSet<String>();
        beginSet.add(beginWord);
        HashSet<String> endSet = new HashSet<String>();
        endSet.add(endWord);
        int counter = 1;
        while (qB.size() > 0 && qE.size() > 0) {
            counter++;
            int lQB = qB.size();
            for (int i = 0; i < lQB; i++) {
                String word = qB.poll();
                for (int j = 0; j < word.length(); j++) {
                    String mask = mask(j, word);
                    List<String> l = map.get(mask);
                    if (l == null) {
                        continue;
                    }
                    for (int k = 0; k < l.size(); k++) {
                        String child = l.get(k);
                        if (endSet.contains(child)) {
                            return counter;
                        }
                        if (beginSet.contains(child)) {
                            continue;
                        }
                        qB.offer(child);
                        beginSet.add(child);
                    }
                }
            }

            counter++;
            int lQE = qE.size();
            for (int i = 0; i < lQE; i++) {
                String word = qE.poll();
                for (int j = 0; j < word.length(); j++) {
                    String mask = mask(j, word);
                    List<String> l = map.get(mask);
                    if (l == null) {
                        continue;
                    }
                    for (int k = 0; k < l.size(); k++) {
                        String child = l.get(k);
                        if (beginSet.contains(child)) {
                            return counter;
                        }
                        if (endSet.contains(child)) {
                            continue;
                        }
                        qE.offer(child);
                        endSet.add(child);
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        testSolutionPractice2_1();

        testSolutionPractice2_4();
        testSolutionPractice2_3();

        testSolutionPractice2_2();
    }

    public static void testSolutionPractice2_1() {
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.ladderLength(
            "hit",
            "cog",
            Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" }));
        boolean passed = output == 5;
        System.out.println("testSolutionPractice2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_2() {
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.ladderLength(
            "hit",
            "cog",
            Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" }));
        boolean passed = output == 5;
        System.out.println("testSolutionPractice2_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_3() {
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.ladderLength(
            "hit",
            "cog",
            Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log" }));
        boolean passed = output == 0;
        System.out.println("testSolutionPractice2_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_4() {
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.ladderLength(
            "abc",
            "sbc",
            Arrays.asList(new String[] { "sbc" }));
        boolean passed = output == 2;
        System.out.println("testSolutionPractice2_4: " + (passed ? "passed" : "failed"));
    }

}
