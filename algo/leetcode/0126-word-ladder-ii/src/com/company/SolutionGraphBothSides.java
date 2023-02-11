package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SolutionGraphBothSides {
        
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
        if (beginIdx == -1 || endIdx == -1) {
            return new ArrayList<>();
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

        Queue<List<Integer>> Q = new LinkedList<>();
        Q.add(new ArrayList<Integer>(){{ add((Integer)begin); }});
        Q.add(new ArrayList<Integer>(){{ add((Integer)end); }});

        boolean[] visitedL = new boolean[G.length];
        visitedL[begin] = true;

        boolean[] visitedR = new boolean[G.length];
        visitedR[end] = true;

        HashMap<Integer, List<List<Integer>>> outputL = new HashMap<>();
        HashMap<Integer, List<List<Integer>>>  outputR = new HashMap<>();

        boolean finished = false;
        while (!finished && !Q.isEmpty()) {
            int level = Q.size();
            for (int i = 0; i < level; i++) {
                List<Integer> p = Q.poll();
                int v = p.get(p.size()-1);
                int startNode = p.get(0);

                if (startNode == begin) {
                    if (visitedR[v] == true) {
                        List<List<Integer>> l = outputL.getOrDefault(v, new ArrayList<>());
                        l.add(p);
                        outputL.put(v, l);
                        finished = true;
                    }
                } else {
                    if (visitedL[v] == true) {
                        List<List<Integer>> l = outputR.getOrDefault(v, new ArrayList<>());
                        l.add(p);
                        outputR.put(v, l);
                        finished = true;
                    }
                }

                if (!finished) {
                    List<Integer> nbrs = G[v];
                    for (int nbr : nbrs) {
                        if ((startNode == begin && visitedL[nbr] == false) || (startNode == end && visitedR[nbr] == false) ) {
                            if (startNode == begin) {
                                visitedL[nbr] = true;
                            } else {
                                visitedR[nbr] = true;
                            }

                            List<Integer> newP = new ArrayList(p);
                            newP.add(nbr);
                            Q.add(newP);
                        }
                    }
                }
            }
        }

        List<List<Integer>> output = new ArrayList<>();

        for(Map.Entry<Integer, List<List<Integer>>> e : outputL.entrySet()) {
            List<List<Integer>> lOutput = e.getValue();
            List<List<Integer>> rOutput = outputR.get(e.getKey());
            if (rOutput == null) {
                continue;
            }
            for (int k = 0; k < lOutput.size(); k++) {
                for (int s = 0; s < rOutput.size(); s++) {
                    List<Integer> o = lOutput.get(k);
                    List<Integer> right = rOutput.get(s);
                    if (right == null) {
                        continue;
                    }
                    for (int t = right.size()-2; t >= 0 ; t--) {
                        o.add(right.get(t));
                    }
                    
                    output.add(o);
                }
            }
        }

        return output;
    }
}
