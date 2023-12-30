import java.util.HashMap;
import java.util.Stack;
import java.util.ArrayList;

class Solution {
    public int calculate(String s) {
        String str = s.replace(" ", "");
        ArrayList<Token> reverse = toReverse(str);
        int result = evalReverse(reverse);
        return result;
    }

    private static HashMap<Character, Integer> p = new HashMap<>() {{ 
        put('=', 1);
        put('+', 2); put('-', 2);
        put('*', 3); put('/', 3);
        put('^', 4);
    }};

    private static class Token {
        public boolean isNum = true;
        public int num = 0;
        public char op = ' ';

        public Token(int num) {
            this.isNum = true;
            this.num = num;
        }

        public Token(char op) {
            this.isNum = false;
            this.op = op;
        }
    }

    private ArrayList<Token> toReverse(String str) {
        Stack<Character> S = new Stack<>();
        ArrayList<Token> res = new ArrayList<>();
        
        Integer num = 0;
        boolean isNumFilled = false;

        //boolean isMinusOpAhead = false;
        
        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
            if (chr-'0' >= 0 && '9'-chr >= 0) {
                isNumFilled = true;
                
                num = num * 10 + (chr-'0');
                /* 
                if (isMinusOpAhead) {
                    isMinusOpAhead = false;
                    num *= -1;
                }
                */
            } else {
                if (isNumFilled) {
                    res.add(new Token(num));
                    isNumFilled = false;
                    num = 0;
                }
                if (chr == '(') {
                    S.push(chr);
                } else if (chr == ')') {
                    while (S.peek() != '(') {
                        res.add(new Token(S.pop()));
                    }
                    S.pop();
                } else {
                    /*
                    if (chr == '-' && S.size() == 0) {
                        isMinusOpAhead = true;
                        continue;
                    }
                    */
                    while (!S.isEmpty() && S.peek() != '(' && p.get(S.peek()) >= p.get(chr)) {
                        res.add(new Token(S.pop()));
                    }
                    S.push(chr);
                }
            }
        }
        if (isNumFilled) {
            res.add(new Token(num));
        }
        while (!S.isEmpty()) {
            res.add(new Token(S.pop()));
        }
        return res;
    }

    private int evalReverse(ArrayList<Token> reverse) {
        Stack<Integer> S = new Stack<>();
        for (int i = 0; i < reverse.size(); i++) {
            Token token = reverse.get(i);
            if (token.isNum) {
                S.push(token.num);
            } else {
                if (token.op == '+') {
                    int d1 = S.pop();
                    int d2 = S.pop();
                    S.push(d1+d2);
                } else if (token.op == '*') {
                    int d1 = S.pop();
                    int d2 = S.pop();
                    S.push(d1*d2);
                } else if (token.op == '-') {
                    int d1 = S.pop();
                    if (S.size() == 0) {
                        S.push(-1 * d1);
                    } else {
                        int d2 = S.pop();
                        S.push(d2-d1);
                    }
                } else {
                    throw new RuntimeException("unsupported expr syntax");
                }
            }
        }
        return S.pop();
    }

    public static void main(String[] args) {
        test9();
        test8();
        test7();
        test6();
        test5();
        test4();
        test3();
        test1();
        test2();
    }

    public static void test9() {
        String s = "1-(     -2)";
        int expOutput = 3;
        Solution sol = new Solution();
        int output = sol.calculate(s);
        boolean passed = output == expOutput;
        System.out.println("test9: " + (passed ? "passed" : "failed"));
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
        String s = "-2+5";
        int expOutput = 3;
        Solution sol = new Solution();
        int output = sol.calculate(s);
        boolean passed = output == expOutput;
        System.out.println("test5: " + (passed ? "passed" : "failed"));
    }

    public static void test6() {
        String s = "(-2+5)";
        int expOutput = 3;
        Solution sol = new Solution();
        int output = sol.calculate(s);
        boolean passed = output == expOutput;
        System.out.println("test6: " + (passed ? "passed" : "failed"));
    }

    public static void test7() {
        String s = "-(-2+5)";
        int expOutput = -3;
        Solution sol = new Solution();
        int output = sol.calculate(s);
        boolean passed = output == expOutput;
        System.out.println("test7: " + (passed ? "passed" : "failed"));
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

    public static void test8() {
        String s = "2147483647";
        int expOutput = 2147483647;
        Solution sol = new Solution();
        int output = sol.calculate(s);
        boolean passed = output == expOutput;
        System.out.println("test8: " + (passed ? "passed" : "failed"));
    }
}