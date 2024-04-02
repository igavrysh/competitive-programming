import java.util.List;
import java.util.ArrayList;

public class SolutionTri {
    private static class TrieNode {
        public TrieNode[] subnodes = new TrieNode[26];
        public boolean isEOW = false;
        public TrieNode() {}
    }

    private void addWordToTrie(String word, TrieNode root) {
        TrieNode curr = root;
        for (int i = word.length()-1; i >= 0; i--) {
            if (curr.subnodes[word.charAt(i)-'a'] == null) {
                curr.subnodes[word.charAt(i)-'a'] = new TrieNode();
            }
            curr = curr.subnodes[word.charAt(i)-'a'];
        }
        curr.isEOW = true;
    }

    // -1 - if false
    // len of the last not blacklisted suffix 
    private int isWordSuffixInBlackList(int l, int r, String word, TrieNode root) {
        TrieNode curr = root;
        for (int i = r; i >= r-10+1; i--) {
            if (i < 0 || i < l) {
                break;
            }
            curr = curr.subnodes[word.charAt(i)-'a'];
            if (curr == null) {
                return -1;
            }
            if (curr.isEOW) {
                return r-i+1-1;
            }
        }
        return -1;
    }

    public int longestValidSubstring(String word, List<String> forbidden) {
        // Time: O(B) + O(W*10) ~ O(B) + O(10*W)
        // Space: O(B)

        TrieNode blockedTrie = new TrieNode();
        for (String forb : forbidden) {
            addWordToTrie(forb, blockedTrie);
        }
        int result = 0;
        int l = 0;
        int r = 0;
        for (r = 0; r < word.length(); r++) {
            int len = isWordSuffixInBlackList(l, r, word, blockedTrie);
            if (len != -1) {
                l = r - len + 1;
            }
            result = Math.max(result, r-l+1);
        }
        return result;
    }

    public static void test1() {
        String word = "cbaaaabc";
        List<String> forbidden = new ArrayList<>() {{
            add("aaa");
            add("cb"); 
        }};
        int expOutput = 4;
        SolutionTri sol = new SolutionTri();
        int output = sol.longestValidSubstring(word, forbidden);
        boolean passed = output == expOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        String word = "leetcode";
        List<String> forbidden = new ArrayList<>() {{
            add("de");
            add("le");
            add("e");
        }};
        int expOutput = 4;
        SolutionTri sol = new SolutionTri();
        int output = sol.longestValidSubstring(word, forbidden);
        boolean passed = output == expOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        String word = "acbc";
        List<String> forbidden = new ArrayList<>() {{
            add("cbc");
            add("acb");
            add("acb");
            add("acbc");
        }};
        int expOutput = 2;
        SolutionTri sol = new SolutionTri();
        int output = sol.longestValidSubstring(word, forbidden);
        boolean passed = output == expOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        String word = "aaaabaaacc";
        List<String> forbidden = new ArrayList<>() {{
            add("bcca");
            add("aaa");
            add("aabaa");
            add("baaac");
        }};
        int expOutput = 4;
        SolutionTri sol = new SolutionTri();
        int output = sol.longestValidSubstring(word, forbidden);
        boolean passed = output == expOutput;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        test4();
        test3();
        test2();
        test1();
        System.out.println("Hello, world!");
    }
}
