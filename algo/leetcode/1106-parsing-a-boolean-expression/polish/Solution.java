package polish;
public class Solution {
    public boolean parseBoolExpr(String exp) {
        char[] stack = new char[2*10000+1];
        int head = -1;
        boolean[] tmp = new boolean[2*10000+1];
        for (int i=0; i<exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '&' || ch == '|' || ch == '!' || ch == 't' || ch == 'f') {
                stack[++head] = ch;
            }
            if (ch == ')') {
                int tmp_head = -1;
                while (stack[head] != '&' && stack[head] != '|' && stack[head] != '!') {
                    tmp[++tmp_head] = stack[head--] == 't';
                }
                boolean res = stack[head] == '&';
                while (tmp_head >= 0) {
                    if (stack[head] == '&') {
                        res = res & tmp[tmp_head];
                    } else if (stack[head] == '|') {
                        res = res | tmp[tmp_head];
                    } else if (stack[head] == '!') {
                        res = !tmp[tmp_head];
                    }
                    tmp_head--;
                }
                stack[head] = (res==true ? 't' : 'f');
            }
        }
        return stack[head] == 't';
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
