package com.company;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return BFS(beginWord, endWord, wordList);
    }

    private int BFS(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> seen = new HashSet<>();
        Queue<String> level = new LinkedList<>();
        seen.add(beginWord);
        level.offer(beginWord);

        int l = 0;
        while (level.size() > 0) {
            l++;
            int currSize = level.size();
            for (int i = 0; i < currSize; i++) {
                String prevElem = level.poll();

                for (int j = 0; j < wordList.size(); j++) {
                    String jW = wordList.get(j);
                    if (isOneCharDiff(jW, prevElem) && !seen.contains(jW)) {
                        if (jW.equals(endWord)) {
                            return l + 1;
                        }
                        seen.add(jW);
                        level.offer(jW);
                    }
                }
            }
        }
        return 0;
    }

    private boolean isOneCharDiff(String w1, String w2) {
        int mismatches = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                mismatches++;
            }
            if (mismatches > 1) {
                break;
            }
        }
        return mismatches == 1 ? true : false;
    }

}
