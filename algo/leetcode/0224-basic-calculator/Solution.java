import java.util.HashMap;
import java.util.Stack;
import java.util.ArrayList;

class Solution {
    // priority: 
    private ArrayList<Character> toReverse(String str) {
        HashMap<Character, Integer> p = new HashMap<>() {{ 
            //put('!', 0);
            put('+', 2); put('-', 2);
            put('*', 3); put('/', 3);
            put('^', 4);
        }};

        Stack<Character> S = new Stack<>();
        ArrayList<Character> res = new ArrayList<>();
        
        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);

            /* 
            if (chr == '-' && i < str.length()-1) {
                char nextChr = str.charAt(i+1);
                if (nextChr == '(' || (nextChr-'0' >= 0 && '9'-nextChr >= 0)) {
                    chr = '!';
                }
            }
            */

            if (chr-'0' >= 0 && '9'-chr >= 0) {
                res.add(chr);
            } else if (chr == '(') {
                S.push(chr);
            } else if (chr == ')') {
                while (S.peek() != '(') {
                    res.add(S.pop());
                }
                S.pop();
            } else {
                while (!S.isEmpty() && S.peek() != '(' && p.get(S.peek()) >= p.get(chr)) {
                    res.add(S.pop());
                }
                S.push(chr);
            }
        }
        while (!S.isEmpty()) {
            res.add(S.pop());
        }
        return res;
    }

    private int evalReverse(ArrayList<Character> reverse) {
        Stack<Integer> S = new Stack<>();
        for (int i = 0; i < reverse.size(); i++) {
            char chr = reverse.get(i);
            if (chr-'0' >= 0 && '9'-chr >= 0) {
                S.push(chr-'0');
            } else {
                if (chr == '+') {
                    int d1 = S.pop();
                    int d2 = S.pop();
                    S.push(d1+d2);
                } else if (chr == '-') {
                    int d1 = S.pop();
                    if (S.size() == 0) {
                        S.push(-1 * d1);
                    } else {
                        int d2 = S.pop();
                        S.push(d2-d1);
                    }
                } else if (chr == '!') {
                    int d1 = S.pop();
                    S.push(d1*-1);
                } else {
                    throw new RuntimeException("unsupported expr syntax");
                }
            }
        }

        return S.pop();
    }
    
    public int calculate(String s) {
        String str = s.replace(" ", "");
        ArrayList<Character> reverse = toReverse(str);
        int result = evalReverse(reverse);
        return result;
    }

    public static void main(String[] args) {
        test5();
        test4();
        test3();
        test1();
        test2();
    }

    public static void test4() {
        String s = "-(2+5)";
        int expOutput = -7;
        Solution sol = new Solution();
        int output = sol.calculate(s);
        boolean passed = output == expOutput;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

    public static void test5() {
        String s = "-2+5)";
        int expOutput = 3;
        Solution sol = new Solution();
        int output = sol.calculate(s);
        boolean passed = output == expOutput;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

    public static void test1() {
        String s = " 2-1 + 2 ";
        int expOutput = 3;
        Solution sol = new Solution();
        int output = sol.calculate(s);
        boolean passed = output == expOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        String s = "1 + 1";
        int expOutput = 2;
        Solution sol = new Solution();
        int output = sol.calculate(s);
        boolean passed = output == expOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        String s = "(1+(4+5+2)-3)+(6+8)";
        int expOutput = 23;
        Solution sol = new Solution();
        int output = sol.calculate(s);
        boolean passed = output == expOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}