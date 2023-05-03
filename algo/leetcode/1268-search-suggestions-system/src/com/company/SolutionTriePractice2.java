package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionTriePractice2 {

    public static void main(String[] args) {
        testSolutionTriePractice2_1();
        testSolutionTriePractice2_2();
        testSolutionTriePractice2_3();
        testSolutionTriePractice2_4();
    }

    private TreeNode root = new TreeNode();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for (int i = 0; i < products.length; i++) {
            add(products[i]);
        }
        TreeNode node = root;
        List<List<String>> output = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < searchWord.length(); i++) {
            int idx = searchWord.charAt(i) - 'a';
            if (node != null) {
                node = node.children[idx];
            }
            
            if (node == null) {
                output.add(new ArrayList<>());
            } else {
                sb.append(searchWord.charAt(i));
                List<String> acc = new ArrayList<>();
                dfs3(node, acc, sb);
                output.add(acc);
            }
        }
        return output;
    }

    public class TreeNode {
        public TreeNode[] children = new TreeNode[26];
        public boolean isEOW = false;
    }

    private void add(String s) {
        int n = s.length();
        TreeNode node = root;
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (node.children[idx] != null) {
                node = node.children[idx];
            } else {
                TreeNode newNode = new TreeNode();
                node.children[idx] = newNode;
                node = newNode;
            }
        }
        node.isEOW = true;
    }

    private void dfs3(TreeNode node, List<String> acc, StringBuilder sb) {
        if (acc.size() == 3) {
            return;
        }

        if (node.isEOW) {
            acc.add(sb.toString());
        }

        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null) {
                sb.append((char)('a'+i));
                dfs3(node.children[i], acc, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void testSolutionTriePractice2_1() {
        String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
        String searchWord = "mouse";
        SolutionTriePractice2 s = new SolutionTriePractice2();
        List<List<String>> output = s.suggestedProducts(products, searchWord);
        boolean passed = output.size() == 5
                && Arrays.deepEquals(output.get(0).toArray(), new String[] { "mobile", "moneypot", "monitor" })
                && Arrays.deepEquals(output.get(1).toArray(), new String[] { "mobile", "moneypot", "monitor" })
                && Arrays.deepEquals(output.get(2).toArray(), new String[] { "mouse", "mousepad" })
                && Arrays.deepEquals(output.get(3).toArray(), new String[] { "mouse", "mousepad" })
                && Arrays.deepEquals(output.get(4).toArray(), new String[] { "mouse", "mousepad" });
        System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionTriePractice2_2() {
        String[] products = { "havana" };
        String searchWord = "havana";
        SolutionTriePractice2 s = new SolutionTriePractice2();
        List<List<String>> output = s.suggestedProducts(products, searchWord);
        boolean passed = output.size() == 6
                && Arrays.deepEquals(output.get(0).toArray(), new String[] { "havana" })
                && Arrays.deepEquals(output.get(1).toArray(), new String[] { "havana" })
                && Arrays.deepEquals(output.get(2).toArray(), new String[] { "havana" })
                && Arrays.deepEquals(output.get(3).toArray(), new String[] { "havana" })
                && Arrays.deepEquals(output.get(4).toArray(), new String[] { "havana" })
                && Arrays.deepEquals(output.get(5).toArray(), new String[] { "havana" });
        System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionTriePractice2_3() {
        String[] products = { "bags", "baggage", "banner", "box", "cloths" };
        String searchWord = "bags";
        SolutionTriePractice2 s = new SolutionTriePractice2();
        List<List<String>> output = s.suggestedProducts(products, searchWord);
        boolean passed = output.size() == 4
                && Arrays.deepEquals(output.get(0).toArray(), new String[] { "baggage", "bags", "banner" })
                && Arrays.deepEquals(output.get(1).toArray(), new String[] { "baggage", "bags", "banner" })
                && Arrays.deepEquals(output.get(2).toArray(), new String[] { "baggage", "bags" })
                && Arrays.deepEquals(output.get(3).toArray(), new String[] { "bags" });
        System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionTriePractice2_4() {
        String[] products = { "havana" };
        String searchWord = "tatiana";
        SolutionTriePractice2 s = new SolutionTriePractice2();
        List<List<String>> output = s.suggestedProducts(products, searchWord);
        boolean passed = output.size() == 7
                && Arrays.deepEquals(output.get(0).toArray(), new String[] {})
                && Arrays.deepEquals(output.get(1).toArray(), new String[] {})
                && Arrays.deepEquals(output.get(2).toArray(), new String[] {})
                && Arrays.deepEquals(output.get(3).toArray(), new String[] {})
                && Arrays.deepEquals(output.get(4).toArray(), new String[] {})
                && Arrays.deepEquals(output.get(5).toArray(), new String[] {})
                && Arrays.deepEquals(output.get(6).toArray(), new String[] {});
        System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
    }

    public static String getMethodName() {
        return new Throwable()
                .getStackTrace()[1]
                .getMethodName();
    }
}
