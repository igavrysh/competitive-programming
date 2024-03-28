import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class SolutionHashSet {
    public int longestValidSubstring(String word, List<String> forbidden) {
        HashSet<String> blacklist = new HashSet<>();
        for (String w : forbidden) {
            blacklist.add(w);
        }
        int maxLen = 0;
        int l = 0;
        for (int r = 0; r < word.length(); r++) {
            int i = 0;
            while (i < 10 && r-i>=l) {
                String cand = word.substring(r-i, r+1);
                if (blacklist.contains(cand)) {
                    l = r-i+1;
                    break;
                }
                i++;
            }
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
        SolutionHashSet sol = new SolutionHashSet();
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
        SolutionHashSet sol = new SolutionHashSet();
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
        SolutionHashSet sol = new SolutionHashSet();
        int output = sol.longestValidSubstring(word, forbidden);
        boolean passed = output == expOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        String word = "aaabccccacacacaabcbaaabacbbbcabcbcaacbabccbababcabaacaacbbcbaabc";
        List<String> forbidden = new ArrayList<>() {{
            String[] tmp = {"bbbacbcb","bcbaaabacb","abbbbcb","bcbcbac","cbaabbbbbb","bbbbaabcb","cccaaaacaa","cbabaaca","baaabacbb","abcabaacaa"};
            for (int i = 0; i < tmp.length; i++) {
                add(tmp[i]);
            }
        }};
        int expOutput = 35;
        SolutionHashSet sol = new SolutionHashSet();
        int output = sol.longestValidSubstring(word, forbidden);
        boolean passed = output == expOutput;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

    public static void test5() {
        String word = "aaaabaaacc";
        List<String> forbidden = new ArrayList<>() {{
            String[] tmp = {"bcca","aaa","aabaa","baaac"};
            for (int i = 0; i < tmp.length; i++) {
                add(tmp[i]);
            }
        }};
        int expOutput = 4;
        SolutionHashSet sol = new SolutionHashSet();
        int output = sol.longestValidSubstring(word, forbidden);
        boolean passed = output == expOutput;
        System.out.println("test5: " + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        test5();
        test4();
        test3();
        test2();
        test1();
        System.out.println("Hello, world!");
    }
}
