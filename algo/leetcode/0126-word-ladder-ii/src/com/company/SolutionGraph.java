package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionGraph {

    private String keyFor(int i, String w) {
        StringBuilder sb = new StringBuilder(w);
        sb.setCharAt(i, '*');
        return sb.toString();
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wl) {
        HashMap<String, List<String>> M = new HashMap<>();
        HashMap<String, Integer> D = new HashMap<>(); 

        ArrayList<String> wordList = new ArrayList<>(wl);
        wordList.add(beginWord);

        for (int idx = 0; idx < wordList.size(); idx++) {
            String word = wordList.get(idx);
            for (int i = 0; i < word.length(); i++) {
                String key = keyFor(i, word);
                ArrayList<String> l = (ArrayList<String>)M.getOrDefault(key, new ArrayList<>());
                l.add(word);
                M.put(key, l);
                D.put(word, idx);
            }
        }

        List<Integer>[] G = new List[wordList.size()];
        int beginIdx = -1, endIdx = -1;
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            if (word.equals(beginWord)) {
                beginIdx = i;
            }
            if (word.equals(endWord)) {
                endIdx = i;
            }
            if (G[i]==null) { G[i] = new ArrayList<>(); }
            for (int j = 0; j < word.length(); j++) {
                String key = keyFor(j, word);
                List<String> nbrs = M.get(key);
                if (key != null) {
                    for (int s = 0; s < nbrs.size(); s++) {
                        int nbr = D.get(nbrs.get(s));
                        if (nbr != i) {
                            G[i].add(nbr);
                        }
                    }
                }
            }
        }
        List<List<Integer>> paths = findPath(beginIdx, endIdx, G);
        List<List<String>> output = new ArrayList<>();

        for (List<Integer> path : paths) {
            List<String> o = new ArrayList<>();
            for (Integer idx : path) {
                o.add(wordList.get(idx));
            }
            output.add(o);
        }
        return output;
    }

    private List<List<Integer>> findPath(int begin, int end, List<Integer>[] G) {
        List<List<Integer>> output = new ArrayList<>();

        Queue<List<Integer>> Q = new LinkedList<>();
        Q.add(new ArrayList<Integer>(){{ add(begin); }});
        boolean[] visited = new boolean[G.length];
        boolean finished = false;
        while (!finished && !Q.isEmpty()) {
            int level = Q.size();
            for (int i = 0; i < level; i++) {
                List<Integer> p = Q.poll();

                int v = p.get(p.size()-1);
                visited[v] = true;

                if (v == end) {
                    output.add(p);
                    finished = true;
                }
                List<Integer> nbrs = G[v];
                for (int nbr : nbrs) {
                    if (visited[nbr] == false || nbr == end) {
                        
                        List<Integer> newP = new ArrayList(p);
                        newP.add(nbr);
                        Q.add(newP);
                    }
                }
            }
        }
        return output;
    }
}
