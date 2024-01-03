import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        BT(0, new StringBuilder(), true, false, result, num, target);
        return result;
    }

    private static String[] ops = {"+", "-", "*"};

    public void BT(int pos, StringBuilder sb, boolean prevPushedOp, boolean prevPushedZero, List<String> result, String num, int target) {
        if (pos == num.length()) {
            String str = sb.toString();
            if ((long)target == eval(str)) {
                result.add(str);
            }
            return;
        }

        if (!prevPushedOp) {
            for (int i = 0; i < ops.length; i++) {
                sb.append(ops[i]);
                BT(pos, sb, true, false, result, num, target);
                sb.deleteCharAt(sb.length()-1);
            }
        }

        if (!prevPushedZero) {
            sb.append(num.charAt(pos));
            prevPushedZero = num.charAt(pos) == '0' && prevPushedOp;
            BT(pos+1, sb, false, prevPushedZero, result, num, target);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    private static class Token {
        public boolean isOp = false;
        public char op = 'q';
        public long var = 0;
        public Token(char op) { this.isOp = true; this.op = op; }
        public Token(long var) { this.isOp = false; this.var = var; }
    }

    public static HashMap<Character, Integer> p = new HashMap<>() {{ 
        put('+', 1); 
        put('-', 1); 
        put('*', 2); 
    }};

    public long eval(String str) {
        ArrayList<Token> tokens = new ArrayList<>();
        Stack<Character> ops = new Stack<>();
        long var = 0;
        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
             if (chr-'0' >= 0 && '9'-chr >= 0) {
                var = var*10 + (chr-'0');
            } else {
                tokens.add(new Token(var));
                var = 0;
                while (!ops.isEmpty() && p.get(ops.peek()) >= p.get(chr)) {
                    tokens.add(new Token(ops.pop()));
                }
                ops.push(chr);
            }
        }
        tokens.add(new Token(var));
        while (!ops.isEmpty()) {
            tokens.add(new Token(ops.pop()));
        }

        Stack<Long> nums = new Stack<>();
        for (int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            if (token.isOp) {
                long var1 = nums.pop();
                long var2 = nums.pop();
                if (token.op == '+') {
                    nums.push(var1+var2);
                } else if (token.op == '-') {
                    nums.push(var2-var1);
                } else {
                    nums.push(var1*var2);
                }
            } else {
                nums.push(token.var);
            }
        }
        return nums.pop();
    }

    public static void main(String[] args) {
        test6();
        test1();
        test2();
        test3();
        test4();
        test5();
    }
    
    public static boolean compAnL(String[] expOutput, List<String> outputL) {
        HashSet<String> set1 = new HashSet<>();
        for (int i = 0; i < expOutput.length; i++) {
            set1.add(expOutput[i]);
        }
        HashSet<String> set2 = new HashSet<>();
        for (int i = 0; i < outputL.size(); i++) {
            set2.add(outputL.get(i));
        }
        return set1.equals(set2);
    }

    public static void test1() {
        String num = "123";
        int target = 6;
        String[] expOutput = {"1*2*3","1+2+3"};
        Solution sol = new Solution();
        List<String> outputL = sol.addOperators(num, target);
        boolean passed = compAnL(expOutput, outputL);
        System.out.println("test1: " + (passed == true ? "true" : "false"));
    }

    public static void test2() {
        String num = "232";
        int target = 8;
        String[] expOutput = {"2*3+2","2+3*2"};
        Solution sol = new Solution();
        List<String> outputL = sol.addOperators(num, target);
        boolean passed = compAnL(expOutput, outputL);
        System.out.println("test2: " + (passed == true ? "true" : "false"));
    }
    
    public static void test3() {
        String num = "3456237490";
        int target = 9191;
        String[] expOutput = {};
        Solution sol = new Solution();
        List<String> outputL = sol.addOperators(num, target);
        boolean passed = compAnL(expOutput, outputL);
        System.out.println("test3: " + (passed == true ? "true" : "false"));
    }

    public static void test4() {
        String num = "105";
        int target = 5;
        String[] expOutput = {"1*0+5","10-5"};
        Solution sol = new Solution();
        List<String> outputL = sol.addOperators(num, target);
        boolean passed = compAnL(expOutput, outputL);
        System.out.println("test4: " + (passed == true ? "true" : "false"));
    }

    public static void test5() {
        String num = "123456789";
        int target = 45;
        String[] expOutput = {
            "1*2*3*4*5-6-78+9","1*2*3*4+5+6-7+8+9","1*2*3+4+5+6+7+8+9","1*2*3+4+5-6*7+8*9","1*2*3+4-5*6+7*8+9",
            "1*2*3+4-5*6-7+8*9","1*2*3-4*5+6*7+8+9","1*2*3-4*5-6+7*8+9","1*2*3-4*5-6-7+8*9","1*2*3-45+67+8+9",
            "1*2*34+56-7-8*9","1*2*34-5+6-7-8-9","1*2+3*4-56+78+9","1*2+3+4+5*6+7+8-9","1*2+3+4-5+6*7+8-9",
            "1*2+3+4-5-6+7*8-9","1*2+3+45+67-8*9","1*2+3-45+6+7+8*9","1*2+34+5-6-7+8+9","1*2+34+56-7*8+9",
            "1*2+34-5+6+7-8+9","1*2+34-56+7*8+9","1*2+34-56-7+8*9","1*2-3*4+5+67-8-9","1*2-3+4-5-6*7+89",
            "1*2-3-4*5+67+8-9","1*2-3-4+56-7-8+9","1*2-34+5*6+7*8-9","1*23+4*5-6+7-8+9","1*23-4-56-7+89",
            "1+2*3*4*5+6+7-89","1+2*3*4+5*6+7-8-9","1+2*3*4-5+6*7-8-9","1+2*3+4*5*6+7-89","1+2*3+4*5-6+7+8+9",
            "1+2*3-4-5-6*7+89","1+2*34-5*6+7+8-9","1+2+3*4*5+6-7-8-9","1+2+3*4+5+6*7-8-9","1+2+3*45-6-78-9",
            "1+2+3+4+5+6+7+8+9","1+2+3+4+5-6*7+8*9","1+2+3+4-5*6+7*8+9","1+2+3+4-5*6-7+8*9","1+2+3-4*5+6*7+8+9",
            "1+2+3-4*5-6+7*8+9","1+2+3-4*5-6-7+8*9","1+2+3-45+67+8+9","1+2-3*4*5+6+7+89","1+2-3*4+5*6+7+8+9",
            "1+2-3*4-5+6*7+8+9","1+2-3*4-5-6+7*8+9","1+2-3*4-5-6-7+8*9","1+2-3+4*5+6*7-8-9","1+2-3+45+6-7-8+9",
            "1+2-3+45-6+7+8-9","1+2-3-4-5*6+7+8*9","1+2-3-45-6+7+89","1+2-34+5+6+7*8+9","1+2-34+5+6-7+8*9",
            "1+2-34-5-6+78+9","1+23*4+5-6-7*8+9","1+23*4-5-6*7+8-9","1+23*4-56+7-8+9","1+23+4+5+6+7+8-9",
            "1+23+4-5*6+7*8-9","1+23+4-5-67+89","1+23-4*5+6*7+8-9","1+23-4*5-6+7*8-9","1+23-4-5+6+7+8+9",
            "1+23-4-5-6*7+8*9","1+23-45+67+8-9","1-2*3*4+5-6+78-9","1-2*3*4-5-6+7+8*9","1-2*3+4*5+6+7+8+9",
            "1-2*3+4*5-6*7+8*9","1-2*3+4+5+6*7+8-9","1-2*3+4+5-6+7*8-9","1-2*3+4+56+7-8-9","1-2*3+45-67+8*9",
            "1-2*3-4+5*6+7+8+9","1-2*3-4-5+6*7+8+9","1-2*3-4-5-6+7*8+9","1-2*3-4-5-6-7+8*9","1-2*34+5*6-7+89",
            "1-2+3*4*5-6-7+8-9","1-2+3+4-5*6+78-9","1-2+3+45+6-7+8-9","1-2+3-4*5-6+78-9","1-2+3-45+6-7+89",
            "1-2-3*4+5+6+7*8-9","1-2-3*4-5-6+78-9","1-2-3+4-5+67-8-9","1-2-3+45-6-7+8+9","1-2-34+5+6+78-9",
            "1-2-34+56+7+8+9","1-2-34-5+6+7+8*9","1-23*4+5+6*7+89","1-23+4*5-6*7+89","1-23+4-5+67-8+9",
            "1-23+45-67+89","1-23-4+5+67+8-9","1-23-4-5-6-7+89","12*3*4-5*6-78+9","12*3+4+5+6-7-8+9",
            "12*3+4+5-6+7+8-9","12*3-4-5-6+7+8+9","12*3-4-56+78-9","12+3*4+5+6-7+8+9","12+3*45-6-7-89",
            "12+3+4-56-7+89","12+3-4*5+67-8-9","12+3-45+6+78-9","12+34-5-6-7+8+9","12-3*4*5+6+78+9",
            "12-3*4-5+67-8-9","12-3+4*5+6-7+8+9","12-3+4+56-7-8-9","12-3-4+5*6-7+8+9","12-3-4-56+7+89",
            "12-3-45-6+78+9"};
        Solution sol = new Solution();
        List<String> outputL = sol.addOperators(num, target);
        boolean passed = compAnL(expOutput, outputL);
        System.out.println("test5: " + (passed == true ? "true" : "false"));
    }

    public static void test6() {
        String num = "2147483648";
        int target = -2147483648;
        String[] expOutput = {};
        Solution sol = new Solution();
        List<String> outputL = sol.addOperators(num, target);
        boolean passed = compAnL(expOutput, outputL);
        System.out.println("test6: " + (passed == true ? "true" : "false"));
    }
}