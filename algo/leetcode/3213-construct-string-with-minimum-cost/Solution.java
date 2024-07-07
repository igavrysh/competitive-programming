import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

class Solution {
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isEOW;
        public int cost;
    }
    private void add(String word, int cost, TrieNode root) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i)-'a';
            if (node.children[ch] == null) {
                node.children[ch] = new TrieNode();
            }
            node = node.children[ch];
        }
        node.isEOW = true;
        if (node.cost == 0) {
            node.cost = cost;
        } else {
            node.cost = Math.min(node.cost, cost);
        }
    }
    public int minimumCost(String target, String[] words, int[] costs) {
        int n = words.length;
        TrieNode root = new TrieNode();
        int max_len = 0;
        for (int i = 0; i < n; i++) {
            add(words[i], costs[i], root);
            max_len = Math.max(max_len, words[i].length());
        }
        // idx 0: stop idx at target, idx 1: cost
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] p1, int[] p2) -> Integer.compare(p1[1], p2[1]));
        TrieNode node = root;
        for (int i = 0; i < Math.min(max_len, target.length()); i++) {
            int ch = target.charAt(i)-'a';
            node = node.children[ch];
            if (node == null) {
                break;
            }
            if (node.isEOW) {
                pq.offer(new int[]{i, node.cost});
            }
        }
        int minCost = -1;
        while (!pq.isEmpty()) {
            int level = pq.size();
            for (int l = 0; l < level; l++) {
                int[] pair = pq.poll();
                if (pair[0] == target.length()-1) {
                    if (minCost == -1) {
                        minCost = pair[1];
                    } else {
                        minCost = Math.min(minCost, pair[1]);
                    }
                    continue;
                }

                node = root;
                for (int i = pair[0]+1 ; i < Math.min(pair[0]+1+max_len, target.length()); i++) {
                    int ch = target.charAt(i)-'a';
                    node = node.children[ch];
                    if (node == null) {
                        break;
                    }
                    if (node.isEOW) {
                        pq.offer(new int[]{i, pair[1]+node.cost});
                    }
                }
            }
            if (minCost != -1) {
                break;
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        test1();

        test2();
    }

    public static void test1() {
        String target = "abcdef";
        String[] words = {"abdef","abc","d","def","ef"};
        int[] costs = {100,1,1,10,5};
        Solution sol = new Solution();
        int output = sol.minimumCost(target, words, costs);
        int expectedOutput = 7;
        boolean passed = output == expectedOutput;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        try (
            BufferedReader reader_in = new BufferedReader(new FileReader("test_big.in"));
            BufferedReader reader_out = new BufferedReader(new FileReader("test_big.out"))
        ) {
            String target = reader_in.readLine().replace("\"", "");
            String[] words = reader_in.readLine().replace("\"", "").split(",");
            String[] costs_s = reader_in.readLine().replace("\"", "").split(",");
            int[] costs = new int[costs_s.length];
            for (int i = 0; i < costs_s.length; i++) {
                costs[i] = Integer.valueOf(costs_s[i]);
            }
            int exp_output = Integer.valueOf(reader_out.readLine());
            Solution sol = new Solution();
            int output = sol.minimumCost(target, words, costs);
            boolean passed = output == exp_output;
            System.out.println("test2: " + (passed ? "passed" : "failed"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}