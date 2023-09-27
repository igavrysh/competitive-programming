import java.util.Stack;

/*
0 1 2 3 4 5
b b c a a c

last idx
b: 1
c: 5
a: 4

0: S = [(b,0)]
1: S = [(b,0)] 
2: S = [(b,0)] c? => [(b,0), (c,2)]
3: S = [(b,0), (c,2)], a?

*/

class Solution {
    public String removeDuplicateLetters(String s) {
        // do not need to populate with -1 as only going to look for existing values
        // so default 0's won't make any diff
        int[] lastIdx = new int[26];
        char[] chrs = s.toCharArray();
        int n = chrs.length;
        for (int i = 0; i < n; i++) {
            int chr = chrs[i] - 'a';
            lastIdx[chr] = i;
        }

        Stack<Integer> S = new Stack<>();
        int[] lastIndexOfStackEl = new int[26];
        for (int i = 0; i < 26; i++) {
            lastIndexOfStackEl[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int chr = chrs[i] - 'a';
            if (lastIndexOfStackEl[chr] != -1) {
                lastIndexOfStackEl[chr] = i;
                continue;
            }
            while (S.size() != 0    // current word stack is not empty
                && S.peek() >= chr   // prev neighbour is greater lexigraphically
                && lastIndexOfStackEl[S.peek()] != lastIdx[S.peek()]    // prev negihb has duplicates left in the right side, otherwise
                                                                        // without this check, I would be remove unique chars that contradicts task desc
            ) {
                int prevChar = S.pop();
                lastIndexOfStackEl[prevChar] = -1;
            }
            S.push(chr);
            lastIndexOfStackEl[chr] = i;
        }
        StringBuilder sb = new StringBuilder();
        while (S.size() > 0) {
            sb.insert(0, (char)(S.pop()+'a'));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        String input = "bcabc";
        String expOutput = "abc";
        Solution s = new Solution();
        String output = s.removeDuplicateLetters(input);
        boolean passed = output.equals(expOutput);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        String input = "cbacdcbc";
        String expOutput = "acdb";
        Solution s = new Solution();
        String output = s.removeDuplicateLetters(input);
        boolean passed = output.equals(expOutput);
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        String input = "bbcaac";
        String expOutput = "bac";
        Solution s = new Solution();
        String output = s.removeDuplicateLetters(input);
        boolean passed = output.equals(expOutput);
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}