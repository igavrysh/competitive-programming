package com.company;

import java.util.ArrayList;
import java.util.List;

public class SolutionPractice2Opt2 {
    private static class Node {
        public Node[] nodes = new Node[26];
        public boolean isEOW = false;
        public int weight = 0;
        public Node() {}
    }

    public void addWord(String word, Node root) {
        char[] w = word.toCharArray();
        Node node = root;
        for (int i = 0; i < w.length; i++) {
            Node next = node.nodes[w[i]-'a'];
            if (next == null) {
                next = new Node();
                node.nodes[w[i]-'a'] = next;
            }
            node = next;
            next.weight += 1;
        }
        node.isEOW = true;
    }

    public void removeWord(String word, Node root) {
        char[] w = word.toCharArray();
        Node node = root;
        for (int i = 0; i < w.length; i++) {
            Node next = node.nodes[w[i]-'a'];
            if (next == null) {
                return;
            }
            node = next;
            next.weight -= 1;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        for (int i = 0; i < words.length; i++) {
            addWord(words[i], root);
        }

        List<String> output = new ArrayList<>();

        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                BT(i, j, board, root, new StringBuilder(), output, root);
            }
        }
        return output;
    }

    private static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    private void BT(int i, int j, char[][] board, Node parent, StringBuilder sb, List<String> output, Node root) {
        int rows = board.length;
        int cols = board[0].length;
        if (board[i][j] == '#' ) {
            return;
        }
        
        Node child = parent.nodes[board[i][j]-'a'];
        if (child == null || child.weight == 0) {
            return;
        }

        if (child.isEOW) {
            String resWord = sb.append(board[i][j]).toString();
            sb.deleteCharAt(sb.length()-1);
            output.add(resWord);
            child.isEOW = false;
            removeWord(resWord, root);
        }

        for (int d = 0; d < dir.length; d++) {
            int newI = i+dir[d][0];
            int newJ = j+dir[d][1];
            if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols) {
                char tmp = board[i][j];
                sb.append(board[i][j]);
                board[i][j] = '#';
                BT(newI, newJ, board, child, sb, output, root);
                board[i][j] = tmp;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        testSolutionPractice2Opt2_1();
        testSolutionPractice2Opt2_2();
        testSolutionPractice2Opt2_3();
    }

    public static void testSolutionPractice2Opt2_1() {
        SolutionPractice2Opt2 solution = new SolutionPractice2Opt2();
        char[][] board = new char[][] {
            { 'o', 'a', 'a', 'n' },
            { 'e', 't', 'a', 'e' },
            { 'i', 'h', 'k', 'r' },
            { 'i', 'f', 'l', 'v' }
        };
        String[] words = new String[] { "oath", "pea", "eat", "rain" };

        List<String> output = solution.findWords(board, words);
        boolean passed = output.contains("eat")
            && output.contains("oath")
            && output.size() == 2;
        System.out.println("testSolutionPractice2Opt2_1:" + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2Opt2_2() {
        SolutionPractice2Opt2 solution = new SolutionPractice2Opt2();
        char[][] board = new char[][] {
            { 'b', 'b', 'a', 'a', 'b', 'a' },
            { 'b', 'b', 'a', 'b', 'a', 'a' },
            { 'b', 'b', 'b', 'b', 'b', 'b' },
            { 'a', 'a', 'a', 'b', 'a', 'a' },
            { 'a', 'b', 'a', 'a', 'b', 'b' }
        };
        String[] words = new String[] { "abbbababaa" };
        List<String> output = solution.findWords(board, words);
        boolean passed = output.contains("abbbababaa")
            && output.size() == 1;
        System.out.println("testSolutionPractice2Opt2_2:" + (passed ? "passed" : "failed"));
    }


    private static void testSolutionPractice2Opt2_3() {
        SolutionPractice2Opt2 solution = new SolutionPractice2Opt2();
        char[][] board = new char[][] {
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'}
         };
        String[] words = new String[] {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        List<String> output = solution.findWords(board, words);
        boolean passed = 1 == 1
            && output.contains("a")
            && output.contains("aa")
            && output.contains("aaa")
            && output.contains("aaaa")
            && output.contains("aaaaa")
            && output.contains("aaaaaa")
            && output.contains("aaaaaaa")
            && output.contains("aaaaaaaa")
            && output.contains("aaaaaaaaa")
            && output.contains("aaaaaaaaaa")
            && output.size() == 10;
        System.out.println("testSolutionPractice2Opt2_3:" + (passed ? "passed" : "failed"));
    }
}
