package recursive;
class Solution {
    public boolean parseBoolExpr(String exp) {
        if (exp.length() == 1) {
            return exp.equals("t");
        }
        return helper(0, exp.length()-1, exp);
    }
    public boolean helper(int start, int end, String exp) {
        char op = exp.charAt(start);
        boolean isAnd = op  == '&';
        boolean res = isAnd;
        int open_brackets = 0;
        int l = 0;
        for (int i = start+2; i <= end-1; i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                open_brackets++;
            }
            if (ch == ')') {
                open_brackets--;
            }
            if ((ch == '!' || ch == '&' || ch == '|') && open_brackets == 0) {
                l = i;
            }
            if ((ch == 't' || ch == 'f' || ch ==')') && open_brackets == 0) {
                boolean val = false;
                if (ch == 't' || ch == 'f') {
                    val = ch=='t';
                } else if (ch == ')') {
                    val = helper(l, i, exp);
                }
                if (op == '&') {
                    res = res && val;
                } else if (op == '|') {
                    res = res || val;
                } else if (op == '!') {
                    res = !val;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
    public static void test1() {
        String exp = "&(|(f))";
        boolean exp_output = false;
        Solution sol = new Solution();
        boolean output = sol.parseBoolExpr(exp);
        boolean passed = exp_output == output;
        System.out.println("test1:"+(passed ? "passed" : "failed"));
    }
    public static void test2() {
        String exp = "|(f,f,f,t)";
        boolean exp_output = true;
        Solution sol = new Solution();
        boolean output = sol.parseBoolExpr(exp);
        boolean passed = exp_output == output;
        System.out.println("test2:"+(passed ? "passed" : "failed"));
    }
    public static void test3() {
        String exp = "!(&(f,t))";
        boolean exp_output = true;
        Solution sol = new Solution();
        boolean output = sol.parseBoolExpr(exp);
        boolean passed = exp_output == output;
        System.out.println("test3:"+(passed ? "passed" : "failed"));
    }
}