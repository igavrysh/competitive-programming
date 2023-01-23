package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    private String keyFor(int i, String w) {
        StringBuilder sb = new StringBuilder(w);
        sb.setCharAt(i, '*');
        return sb.toString();
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> M = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String key = keyFor(i, word);
                ArrayList<String> l =  (ArrayList<String>)M.getOrDefault(key, new ArrayList<>());
                l.add(word);
                M.put(key, l);
            }
        }

        Queue<List<String>> Q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        List<String> initialP = new ArrayList<>();
        initialP.add(beginWord);
        Q.add(initialP);

        int minSize = Integer.MAX_VALUE;
        boolean found = false;
        while (!Q.isEmpty() && !found) {
            int level = Q.size();
            List<String> toMarkVisited = new ArrayList<>();
            while (level > 0) {
                List<String> path = Q.poll();
                String last = path.get(path.size()-1);
                toMarkVisited.add(last);
                if (last.equals(endWord)) {
                    if (minSize >= path.size()) {
                        minSize = path.size();
                        Q.add(path);
                    }
                    found = true;
                    level--;
                    continue;
                }
        
                for (int i = 0; i < last.length(); i++) {
                    String key = keyFor(i, last);
                    if (M.containsKey(key)) {
                        List<String> nextNodes = M.get(key);
                        for (String nextNode : nextNodes) {
                            if (!visited.contains(nextNode) && nextNode != last) {
                                List<String> newPath = new ArrayList<>(path);
                                newPath.add(nextNode);
                                Q.add(newPath);
                            }
                        }
                    }
                }
                level--;
            }
            for (String v : toMarkVisited) {
                visited.add(v);
            }
        }

        List<List<String>> output = new ArrayList<>();
        for (List<String> l : Q) {
            if (l.get(l.size()-1).equals(endWord) && l.size() == minSize) {
                output.add(l);
            }
        }

        return output;
    }
}