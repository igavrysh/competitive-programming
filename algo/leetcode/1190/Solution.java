import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        // (ed(et(oc))el)
        // 0 3 6
        int prev_l = -1;
        int prev_r = -1;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int start_idx = -1;
        int offset = -1;
        int prev_end = -1;
        boolean at_least_one = false;
        for (int i = 0; i < s.length(); i++) {
            System.out.println("i:" + i);
            if (i == 10) {
                int t = 11;
            }
            if (s.charAt(i) == '(') {
                at_least_one = true;
                if (stack.size() == 0) {
                    sb.append(s.substring(prev_end+1, i));
                    start_idx = i;
                    offset = sb.length();
                }
                stack.push(i);
            } else if (s.charAt(i) == ')' ) {
                int level = stack.size();
                int l_idx = stack.pop();
                if (level%2 == 0) {
                    if (prev_r == -1) {
                        sb.insert(sb.length(), s.substring(l_idx+1, i));
                    } else {
                        if (prev_r+1 < i) {
                            sb.insert(sb.length(), s.substring(prev_r+1, i));
                        }
                        if (l_idx+1 < prev_l) {
                            sb.insert(offset, s.substring(l_idx+1, prev_l));

                        }
                    }
                } else {
                    if (prev_r == -1) {
                        sb.insert(sb.length(), reverse(s, l_idx+1, i));
                    } else {
                        sb.insert(offset, reverse(s, prev_r+1, i));
                        sb.insert(sb.length(), reverse(s, l_idx+1, prev_l));
                    }
                }
                if (level != 1) {
                    prev_r = i;
                    prev_l = l_idx;
                } else {
                    prev_end = i;
                    prev_r = -1;
                    prev_l = -1;
                }
            }
        }
        if (prev_end != -1) {
            sb.insert(sb.length(), s.substring(prev_end+1, s.length()));
        }
        return !at_least_one ? s : sb.toString();
    }
    private String reverse(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = end-1; i >= start; i--) {
            sb.insert(sb.length(), s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        String s = "n(ev(t)((()lfevf))yd)cb()";
        String expOutput = "";
        Solution sol = new Solution();
        String output = sol.reverseParentheses(s);
        boolean passed = output.equals(expOutput);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }
}
