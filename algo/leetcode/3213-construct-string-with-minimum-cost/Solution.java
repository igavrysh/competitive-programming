import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        int[] dp = new int[target.length()];
        int i = 0;
        TrieNode node = root.children[target.charAt(i)-'a'];
        while (node != null) {
            if (node.isEOW) {
                dp[i] = node.cost;
            }
            i++;
            if (i < target.length()) {
                node = node.children[target.charAt(i)-'a'];
            } else {
                node = null;
            }
        }
        for (i = 0; i < target.length(); i++) {
            if (dp[i] == 0) {
                continue;
            }
            int j = i+1;
            if (j >= target.length()) {
                continue;
            }
            node = root.children[target.charAt(j)-'a'];
            while (node != null) {
                if (node.isEOW) {
                    if (dp[j] == 0) {
                        dp[j] = dp[i] + node.cost;
                    } else {
                        dp[j] = Math.min(dp[j], dp[i] + node.cost);
                    }
                }
                j++;
                if (j < target.length()) {
                    node = node.children[target.charAt(j)-'a'];
                } else {
                    node = null;
                }
            }
        }
        return dp[target.length()-1] == 0 ? -1 : dp[target.length()-1];
    }

    public static void main(String[] args) {
        test3();
        test1();
        test2();
        test_big();
    }

    public static void test1() {
        String target = "abcdef";
        String[] words = {"abdef","abc","d","def","ef"};
        int[] costs = {100,1,1,10,5};
        Solution sol = new Solution();
        int output = sol.minimumCost(target, words, costs);
        int expectedOutput = 7;
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        String target = "n";
        String[] words = {"n","n","n","n"};
        int[] costs = {2,1,1,1};
        Solution sol = new Solution();
        int output = sol.minimumCost(target, words, costs);
        int expectedOutput = 1;
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        String target = "sgsipzma";
        String[] words = {"s","s","g","ipzma"};
        int[] costs = {1,5,2,1};
        Solution sol = new Solution();
        int output = sol.minimumCost(target, words, costs);
        int expectedOutput = 5;
        boolean passed = output == expectedOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test_big() {
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
            System.out.println("test_big: " + (passed ? "passed" : "failed"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}