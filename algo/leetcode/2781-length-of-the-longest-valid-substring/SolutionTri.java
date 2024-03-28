import java.util.List;
import java.util.ArrayList;

public class SolutionTri {
    private static class TriNode {
        public TriNode[] subNodes = new TriNode[26];
        public boolean isEOW = false;
        public TriNode() {}
    }

    private void addWordToTri(String word, TriNode root) {
        TriNode curr = root;
        for (int i = word.length()-1; i >= 0; i--) {
            char ch = word.charAt(i);
            curr.subNodes[ch-'a'] = new TriNode();
            curr = curr.subNodes[ch-'a'];
        }
        curr.isEOW = true;
    }
    // -1 = word is not in a tri
    // positive result if word is in Tri, but maxSublen is not in Tri
    private int isWordInTri(String word, int l, int r, TriNode root) {
        TriNode curr = root;
        int maxSublen = 0;
        for (int i = r; i >= l; i--) {
            char ch = word.charAt(i);
            curr = curr.subNodes[ch-'a'];
            if (curr == null || (r-l+1) > 10) {
                return -1;
            }
            if (curr.isEOW) {
                return maxSublen;
            } else {
                maxSublen++;
            }
        }
        return !curr.isEOW ? -1 : maxSublen;
    }

    public int longestValidSubstring(String word, List<String> forbidden) {
        TriNode blacklistTri = new TriNode();
        for (String w : forbidden) {
            addWordToTri(w, blacklistTri);
        }
        int maxLen = 0;
        int l = 0;
        for (int r = 0; r < word.length(); r++) {
            int len = isWordInTri(word, l, r, blacklistTri);
            System.out.println("l:" + l + ", r:" + r + " , len:" + len);
            if (len >= 0) {
                l = r-len+1;
            } else {}
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
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

    public static void main(String[] args) {
        test3();
        test2();
        test1();
        System.out.println("Hello, world!");
    }
}
