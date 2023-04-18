import java.util.LinkedList;

public class SolutionStack {
    private boolean isOperation(char c) {
        return c == '*' || c == '/' || c == '+' || c == '-';
    }

    public int calculate(String s) {
        char[] chrs = s.replace(" ", "").toCharArray();
        LinkedList<Integer> values = new LinkedList<>();
        LinkedList<Character> ops = new LinkedList<>();
        int acc = 0;
        for (int i = 0; i <= chrs.length; i++) {
            if (i == chrs.length || isOperation(chrs[i])) {
                values.add(acc);
                acc = 0;
            }

            if ((i==chrs.length || isOperation(chrs[i])) 
                && (!ops.isEmpty() && (ops.get(ops.size()-1) == '*' || ops.get(ops.size()-1) == '/')))  
            {
                int val2 = values.removeLast();
                int val1 = values.removeLast();
                char op = ops.removeLast();
                if (op == '*') {
                    values.add(val1*val2);
                }
                if (op == '/') {
                    values.add(val1/val2);
                }
            }

            if (i < chrs.length) {
                if (isOperation(chrs[i])) {
                    ops.add(chrs[i]);
                }  else {
                    acc = acc * 10 + (chrs[i]-'0');
                }
            }
        }

        while (!ops.isEmpty()) {
            int val1 = values.removeFirst();
            int val2 = values.removeFirst();
            char op = ops.removeFirst();
            if (op == '+') {
                values.addFirst(val1+val2);
            }
            if (op == '-') {
                values.addFirst(val1-val2);
            }
        }
        return values.removeLast();
    }
}
