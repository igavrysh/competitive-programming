class Solution {
    public String pushDominoes(String dominoes) {
        char[] chrs = dominoes.toCharArray();
        int n = chrs.length;
        int[] DPIdxOfLastRight = new int[n];
        // L = "\", R = "/"
        int idxOfLastRight = -1;
        for (int i = 0; i < n; i++) {
            if (chrs[i] == 'R') {
                idxOfLastRight = i;
            }
            DPIdxOfLastRight[i] = idxOfLastRight;
            if (chrs[i] == 'L') {
                idxOfLastRight = -1;
            }
        }

        int[] DPIdxOfLastLeft = new int[n];
        int idxOfLastLeft = -1;
        for (int i = n-1; i >= 0; i--) {
            if (chrs[i] == 'L') {
                idxOfLastLeft = i;
            }
            DPIdxOfLastLeft[i] = idxOfLastLeft;
            if (chrs[i] == 'R') {
                idxOfLastLeft = -1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (DPIdxOfLastLeft[i] == -1 && DPIdxOfLastRight[i] == -1) {
                sb.append(".");
            } else if (DPIdxOfLastLeft[i] != -1 && DPIdxOfLastRight[i] == -1) {
                sb.append("L");
            } else if (DPIdxOfLastLeft[i] == -1 && DPIdxOfLastRight[i] != -1) {
                sb.append("R");
            } else {
                int length = DPIdxOfLastLeft[i] - DPIdxOfLastRight[i] + 1;
                if (length % 2 == 1 && i == DPIdxOfLastRight[i] + length/2) {
                    sb.append(".");
                } else {
                    if (i < DPIdxOfLastRight[i] + length/2) {
                        sb.append("R");
                    } else {
                        sb.append("L");
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        testSolution_1();
        testSolution_2();
        testSolution_3();
    }

    public static void testSolution_1() {
        
        String dominoes = "RR.L";
        Solution s = new Solution();
        String output = s.pushDominoes(dominoes);
        String expected = "RR.L";
        boolean passed = output.equals(expected);
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        String dominoes = ".L.R...LR..L..";
        Solution s = new Solution();
        String output = s.pushDominoes(dominoes);
        String expected = "LL.RR.LLRRLL..";
        boolean passed = output.equals(expected);
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_3() {
        String dominoes = ".L.R...LL..L..";
        Solution s = new Solution();
        String output = s.pushDominoes(dominoes);
        String expected = "LL.RR.LLLLLL..";
        boolean passed = output.equals(expected);
        System.out.println("testSolution_3: " + (passed ? "passed" : "failed"));
    }
} 