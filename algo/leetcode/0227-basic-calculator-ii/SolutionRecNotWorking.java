class SolutionRecNotWorking {
    public int calculate(String s) {
        char[] chrs = s.replace(" ", "").toCharArray();
        return calculate(0, chrs.length, chrs);
    }

    private int calculate(int from, int to, char[] chrs) {
        int idx = idxOf('+', from, to, chrs);
        if (idx != -1) {
            int op1 = calculate(from, idx, chrs);
            int op2 = calculate(idx+1, to, chrs);
            return  op1 + op2;
        }

        idx = idxOf('-', from, to, chrs) ; 
        if (idx != -1) {
            int op1 = calculate(from, idx, chrs);
            int op2 = calculate(idx, to, chrs);
            return  op1 + op2;
        }

        idx = idxOf('*', from, to, chrs) ; 
        if (idx != -1) {
            int op1 = calculate(from, idx, chrs);
            int op2 = calculate(idx+1, to, chrs);
            return  op1 * op2;
        }

        idx = idxOf('/', from, to, chrs) ; 
        if (idx != -1) {

            int op1 = calculate(from, idx, chrs);
            int op2 = calculate(idx+1, to, chrs);
            return  op1 / op2;
        }

        return toInteger(from, to, chrs);
    }

    private int idxOf(char c, int from, int to, char[] chrs)  {
        if (c == '-' && chrs[from] == '-') {
            from++;
        }
        for (int i = to-1; i >= from; i--) {
            if (c == chrs[i]) {
                return i;
            }
        }
        return -1;
    }

    private int toInteger(int from, int to, char[] chrs) {
        int acc = 0;
        int sign = 1;
        if (chrs[from] == '-') {
            from++;
            sign = -1;
        }
        for (int i = from; i < to; i++) {
            acc = acc*10 + chrs[i]-'0';
        }
        return sign * acc;
    }
}