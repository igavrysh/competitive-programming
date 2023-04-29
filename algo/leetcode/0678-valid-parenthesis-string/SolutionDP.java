public class SolutionDP {
    // ! NOT WORKING
    public static void main(String[] args) {
        testSolution_1();
        testSolution_2();
        testSolution_3();
        testSolution_40();
        testSolution_4();
        testSolution_5();
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

        // 100 x 100 x 100 x 100
        Boolean[][][][][] DP = new Boolean[n][n][n][leftToAdd+1][rightToAdd+1];
        return DP(0, 0, 0, leftToAdd, rightToAdd, chrs, n, DP);
    }

    private boolean DP(int idx, int l, int r, int leftToAdd, int rightToAdd, char[] chrs, int n, Boolean[][][][][] DP) {
        if (idx >= chrs.length || l >= chrs.length || r >= chrs.length) {
            return l==r && leftToAdd == 0 && rightToAdd == 0;
        }
        if (leftToAdd < 0 || rightToAdd < 0) {
            return false;
        }
        if (l<r) {
            return false;
        }

        for (int i = idx; i < chrs.length; i++) {
            if (l < r) {
                return false;
            }
            if (chrs[i] == '(') {
                l++;
            } else if (chrs[i] == ')') {
                r++;
            } else if (chrs[i] == '*') {
                Boolean res = DP[i][l][r][leftToAdd][rightToAdd];
                if (res != null) {
                    DP[i][l][r][leftToAdd][rightToAdd] = res;
                    return res;
                } else {
                    if (res == null || res == false) {
                        res = DP(i+1, l, r, leftToAdd, rightToAdd, chrs, n, DP);
                    }
                    if (leftToAdd > 0 && (res == null || res == false)) {
                        res = DP(i+1, l+1, r, leftToAdd-1, rightToAdd, chrs, n, DP);
                    }
                    if (rightToAdd > 0 && (res == null || res == false)) {
                        res = DP(i+1, l, r+1, leftToAdd, rightToAdd-1, chrs, n, DP);
                    }
                    
                    DP[i][l][r][leftToAdd][rightToAdd] = res;
                    
                    return res;
                }   
            }
        }

        return l==r && leftToAdd == 0 && rightToAdd == 0;
    }

    public static void testSolution_1() {
        String s = "(*))";
        SolutionDP sol = new SolutionDP();
        boolean expectedOutput = true;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        String s = "(*)";
        SolutionDP sol = new SolutionDP();
        boolean expectedOutput = true;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_3() {
        String s = "(";
        SolutionDP sol = new SolutionDP();
        boolean expectedOutput = false;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_40() {
        String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        SolutionDP sol = new SolutionDP();
        boolean expectedOutput = true;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_40: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_4() {
        String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        SolutionDP sol = new SolutionDP();
        boolean expectedOutput = true;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_5() {
        String s = "((()))()(())(*()()())**(())()()()()((*()*))((*()*)";
        SolutionDP sol = new SolutionDP();
        boolean expectedOutput = true;
        boolean output = sol.checkValidString(s);
        boolean passed = output == expectedOutput;
        System.out.println("testSolution_5: " + (passed ? "passed" : "failed"));
    }
}


///
/*
(( () )) () (()) (* ()()() ) ** ( () ) ()()()() ((* () *)) ((*()*)

( ( ( ( () ( ()()() * () ( ( ( ( (*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"

(((( () ( ()()() * () (((((*) ()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)() 

 */