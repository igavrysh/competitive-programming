package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution2 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        Map<String, List<String>> comb = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < L; i++) {
                String key = key(word, i);
                List<String> list = comb.getOrDefault(key, new ArrayList<>());
                list.add(word);
                comb.put(key, list);
            }
        });

        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair<>(beginWord, 1));
        Set<String> visited = new HashSet<>();
        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.poll();
            int level = node.getValue();
            String word = node.getKey();
            visited.add(word);

            for (int i = 0; i < L; i++) {
                String key = key(word, i);
                List<String> nodes = comb.get(key);
                if (nodes == null) {
                    continue;
                }

                for (String next : nodes) {
                    if (next.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.contains(next)) {
                        Q.offer(new Pair<>(next, level + 1));
                    }
                }
            }
        }
        return 0;
    }

    private String key(String word, int i) {
        StringBuilder sb = new StringBuilder(word);
        sb.setCharAt(i, '*');
        return sb.toString();
    }

    class Pair<K, V> {
        K k;
        V v;
        public Pair(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public K getKey() {
            return k;
        }

        public V getValue() {
            return v;
        }
    }

}
