import java.util.Stack;

class Solution {
    public String decodeAtIndex(String s, int _k) {
        long k = (long)_k;
        k--; // make it 0-based
        char[] chrs = s.toCharArray();
        int n = chrs.length;

        Stack<String> words = new Stack<>();
        Stack<Integer> by = new Stack<>();
        Stack<Character> ops = new Stack<>();   // '+' for adding, '*' for multiplying
    
        long prevSize = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int val = chrs[i]-'0';
            if (val >= 0 && val <= 9) {
                if (sb.length() > 0) {
                    int wordLength = sb.length();
                    by.push(wordLength);
                    words.push(sb.toString());
                    ops.push('+');
                    sb = new StringBuilder();
                    prevSize += wordLength;
                }

                int mult = chrs[i]-'0';
                by.push(mult);
                words.push("");
                ops.push('*');
                prevSize *= mult;
            } else {
                sb.append(chrs[i]);
            }        
        }
        if (sb.length() > 0) {
            int wordLength = sb.length();
            by.push(wordLength);
            words.push(sb.toString());
            ops.push('+');
            prevSize += wordLength;
        }

        long size = prevSize;

        while (ops.size() > 0) {
            int c_by = by.pop();
            String c_word = words.pop();
            char c_ops = ops.pop();
            if (c_ops == '+') {
                if (k < size && k >= size-c_by) {
                    long leftPart = size-c_by;
                    long idx = k - leftPart;
                    return c_word.substring((int)idx, (int)idx+1);
                } else {
                    size -= c_by;
                }
            } else if (c_ops == '*') {
                long c_base = size / c_by;
                k = k - ((long)(k / c_base) * c_base);
                size /= c_by;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        String s = "leet2code3";
        int k = 10;
        String expOutput = "o";
        Solution sol = new Solution();
        String output = sol.decodeAtIndex(s, k);
        boolean passed = output.equals(expOutput);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        String s = "ha22";
        int k = 5;
        String expOutput = "h";
        Solution sol = new Solution();
        String output = sol.decodeAtIndex(s, k);
        boolean passed = output.equals(expOutput);
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        String s = "a2345678999999999999999";
        int k = 1;
        String expOutput = "a";
        Solution sol = new Solution();
        String output = sol.decodeAtIndex(s, k);
        boolean passed = output.equals(expOutput);
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        String s = "yyuele72uthzyoeut7oyku2yqmghy5luy9qguc28ukav7an6a2bvizhph35t86qicv4gyeo6av7gerovv5lnw47954bsv2xruaej";
        int k = 123365626;
        String expOutput = "l";
        Solution sol = new Solution();
        String output = sol.decodeAtIndex(s, k);
        boolean passed = output.equals(expOutput);
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }
}