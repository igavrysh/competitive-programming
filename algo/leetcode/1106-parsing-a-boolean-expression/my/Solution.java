package my;
import java.util.Stack;
class Solution {
    public boolean parseBoolExpr(String exp) {
        int n = exp.length();
        Stack<Character> ops = new Stack<>();
        Stack<Boolean> operands = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = exp.charAt(i);
            if (ch == '&' || ch == '|' || ch == '!') {
                ops.push(ch);
                if (ch == '&') {
                    operands.push(true);
                }
                if (ch == '|') {
                    operands.push(false);
                }
                continue;
            }
            if (ch == ')' || ch == ',') {
                if (ch == ',' || (ch == ')' && ops.peek() == '&' || ops.peek() == '|')) {
                    boolean val = operands.pop();
                    boolean other_val = operands.pop();
                    if (ops.peek() == '&') {
                        operands.push(val && other_val);
                    }
                    if (ops.peek() == '|') {
                        operands.push(val || other_val);
                    }
                }
                if (ch == ')' && ops.peek() == '!') {
                    operands.push(!operands.pop());
                }
                if (ch == ')') {
                    ops.pop();
                }
            }
            if (ch == 't' || ch == 'f') {
                operands.push(ch == 't');
            }
        }
        return operands.pop();
    }
    public static void main(String[] args) {
        test1();
    }
    public static void test1() {
        String exp = "!(&(f,t))";
        boolean exp_output = true;
        Solution sol = new Solution();
        boolean output = sol.parseBoolExpr(exp);
        boolean passed = output == exp_output;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }
}