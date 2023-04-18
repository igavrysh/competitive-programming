class SolutionOptimal {
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        int curNum = 0;
        int lastNum = 0;
        int total = 0;
        char curOp = '+';

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(chars[i])) {
                lastNum = curNum;
                curNum = 0;
                while (i < s.length() && Character.isDigit(chars[i])) {
                    curNum = (curNum * 10) + (chars[i] - '0');
                    i++;
                }
                i--;
            }
            
            if ((!Character.isDigit(chars[i]) && chars[i] != ' ') || i == s.length() - 1) {
                if (curOp == '+' || curOp == '-') {
                    total += lastNum;
                    curNum = curOp == '-' ? curNum * -1 : curNum;
                } else if (curOp == '*') {
                    curNum = lastNum * curNum;
                } else if (curOp == '/') {
                    curNum = lastNum / curNum;
                }

                curOp = chars[i];
            }
        }

        return total + curNum;
    }
}
