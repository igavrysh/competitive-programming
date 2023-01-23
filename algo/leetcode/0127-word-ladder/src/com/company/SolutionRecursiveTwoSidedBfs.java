package com.company;

import java.util.HashSet;
import java.util.List;

public class SolutionRecursiveTwoSidedBfs {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        HashSet<String> dict = new HashSet<>(wordList);
        HashSet<String> start = new HashSet<>();
        start.add(beginWord);
        HashSet<String> end = new HashSet<>();
        end.add(endWord);
        dict.addAll(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        return bfs(start, end, dict, 2);
    }

    private int bfs(HashSet<String> start, HashSet<String> end, HashSet<String> dict, int l) {
        if (start.size() == 0) {
            return 0;
        }
        if (start.size() > end.size()) {
            return bfs(end, start, dict, l);
        }

        HashSet<String> nxt = new HashSet<>();
        for (String s : start) {
            char[] chrs = s.toCharArray();
            for (int i = 0; i < chrs.length; i++) {
                char tmp = chrs[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == chrs[i]) { continue; }
                    chrs[i] = c;
                    String nxtStr = new String(chrs);
                    if (end.contains(nxtStr)) { return l; }
                    if (dict.contains(nxtStr)) {
                        dict.remove(nxtStr);
                        nxt.add(nxtStr);
                    }
                }

                chrs[i] = tmp;
            } 
        }
        start = nxt;
        return bfs(start, end, dict, l+1);
    }
}
