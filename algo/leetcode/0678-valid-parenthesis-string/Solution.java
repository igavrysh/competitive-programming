class Solution {

    public static void main(String[] args) {
        testSolution_1();
        testSolution_2();
        testSolution_3();
        testSolution_4();
    }

    public boolean checkValidString(String s) {
        char[] chrs = s.toCharArray();
        int n = chrs.length;

        int left = 0, right = 0, stars = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == '(') {
                left++;
            } else if (chrs[i] == ')') {
                right++;
            } else if (chrs[i] == '*') {
                stars++;
            }
        }

        int balance = left - right;

        int leftToAdd = balance < 0 ? -balance : 0;
        int rightToAdd = balance > 0 ? balance : 0;

        int startsLeft = stars - (leftToAdd + rightToAdd);
        if (startsLeft < 0) {
            return false;
        }

        int l = 0, r = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == '(') {
                l++;
            } else if (chrs[i] == ')') {
                r++;
            } else if (chrs[i] == '*') {
                if (leftToAdd > 0) {
                    l++;
                    leftToAdd--;
                } else if (rightToAdd > 0) {
                    if (l>r) {
                        r++;
                        rightToAdd--;
                    }
                } else {
                    // just empty - do nothing
                }
            }

            if (l < r) {
                return false;
            }
        }

        return l==r;
    }

    public static void testSolution_1() {
        String s = "(*))";
        Solution sol = new Solution();
        boolean expectedOutput = true;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        String s = "(*)";
        Solution sol = new Solution();
        boolean expectedOutput = true;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_3() {
        String s = "(";
        Solution sol = new Solution();
        boolean expectedOutput = false;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_4() {
        String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        Solution sol = new Solution();
        boolean expectedOutput = true;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_4: " + (passed ? "passed" : "failed"));

    }
}