import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int n = num.length()+1;
        int targetSize = n-k;
        for (int i = 0; i < num.length(); i++) {
            int currD = num.charAt(i) - '0';
            int toBeAddedFromRight = num.length() - i - 1;

            while (stack.peek() > currD && (stack.size() + toBeAddedFromRight >= targetSize)) {
                stack.pop();
            }
            stack.push(currD);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            if (stack.size() <= targetSize) {
                int currD = stack.pop();
                char chr = (char)('0' + currD);
                sb.insert(0, chr);
            } else {
                stack.pop();
            }
        }

        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        if (sb.length() == 0) {
            sb.append('0');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        test2();
        test3();
        test4();
        test1();
    }

    public static void test1() {
        String num = "1432219";
        int k = 3;
        String expOutput = "1219";
        Solution sol = new Solution();
        String output = sol.removeKdigits(num, k);
        boolean passed = output.equals(expOutput);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        String num = "100200";
        int k = 1;
        String expOutput = "200";
        Solution sol = new Solution();
        String output = sol.removeKdigits(num, k);
        boolean passed = output.equals(expOutput);
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        String num = "100000";
        int k = 1;
        String expOutput = "0";
        Solution sol = new Solution();
        String output = sol.removeKdigits(num, k);
        boolean passed = output.equals(expOutput);
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test4() {
        String num = "9";
        int k = 1;
        String expOutput = "0";
        Solution sol = new Solution();
        String output = sol.removeKdigits(num, k);
        boolean passed = output.equals(expOutput);
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }
}

 