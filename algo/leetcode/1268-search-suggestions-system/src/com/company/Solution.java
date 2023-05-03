package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    Node root = new Node();

    class Node {
        Node[] nodes = new Node[26];
        boolean isEOW = false;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for (String product : products) {
            add(product);
        }

        List<List<String>> output = new ArrayList<>();
        char[] C = searchWord.toCharArray();
        Node node = root;
        String accWord = "";
        for (int i = 0; i < C.length; i++) {
            List<String> currOutput = new ArrayList<>();
            if (node != null) {
                int idx = idx(C[i]);
                if (node.nodes[idx] != null) {
                    node = node.nodes[idx];
                } else {
                    node = null;
                }
                accWord += C[i];
                dfs(node, accWord, currOutput);
            }
            output.add(currOutput);
        }
        return output;
    }

    private int idx(char c) {
        return c - 'a';
    }

    private void add(String word) {
        if (word.length() == 0) {
            return;
        }

        char[] C = word.toCharArray();
        Node node = root;
        for (int i = 0; i < C.length; i++) {
            int idx = idx(C[i]);
            if (node.nodes[idx] == null) {
                node.nodes[idx] = new Node();
            }
            node = node.nodes[idx];
        }
        node.isEOW = true;
    }

    private void dfs(Node node, String accWord, List<String> output) {
        if (node == null) {
            return;
        }
        if (node.isEOW) {
            output.add(accWord);
            if (output.size() == 3) {
                return;
            }
        }
        for (int i = 0; i < node.nodes.length; i++) {
            if (output.size() == 3) {
                return;
            }
            if (node.nodes[i] != null) {
                dfs(node.nodes[i], accWord + (char) ('a' + i), output);
            }
        }
    }
}
