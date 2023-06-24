package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }

        Set<String> outputSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                DFS(i, j, board, trie, outputSet, "");
            }
        }
        return new ArrayList<>(outputSet);
    }

    private void DFS(int i, int j, char[][] board, Trie words, Set<String> output, String acc) {
        if (!words.startsWith(acc)) {
            return;
        }

        if (words.search(acc)) {
            output.add(acc);
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] == '#') {
            return;
        }

        char c = board[i][j];
        board[i][j] = '#';
        DFS(i + 1, j, board, words, output, acc + c);
        DFS(i - 1, j, board, words, output, acc + c);
        DFS(i, j + 1, board, words, output, acc + c);
        DFS(i, j - 1, board, words, output, acc + c);
        board[i][j] = c;
    }

    public class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    node.put(ch, new TrieNode());
                }
                node = node.get(ch);
            }
            node.setEnd();
        }

        public TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.containsKey(ch)) {
                    node = node.get(ch);
                } else {
                    return null;
                }
            }
            return node;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

    }

    public class TrieNode {

        private TrieNode[] links;

        private boolean isEnd;

        private final int R = 26;

        public TrieNode() {
            links = new TrieNode[26];
        }

        private int index(char ch) {
            int output = ch - 'a';
            return output;
        }

        public boolean containsKey(char ch) {
            return links[index(ch)] != null;
        }

        public TrieNode get(char ch) {
            return links[index(ch)];
        }

        public void put(char ch, TrieNode node) {
            links[index(ch)] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}
