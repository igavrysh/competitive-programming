import java.util.LinkedList;

public class SolutionStack {
    public int calculate(String s) {
        char[] chrs = s.replace(" ", "").toCharArray();
        LinkedList<Integer> values = new LinkedList<>();
        LinkedList<Character> ops = new LinkedList<>();
        int acc = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == '*' || chrs[i] == '/' || chrs[i] == '+' || chrs[i] == '-' || i == chrs.length-1) {
                values.add(acc);
                acc = 0;
            }

            if ((i==chrs.length-1 || chrs[i] == '*' || chrs[i] == '/' || chrs[i] == '+' || chrs[i] == '-') 
                && (ops.size() > 0 && (ops.get(ops.size()-1) == '*' || ops.get(ops.size()-1) == '/')))  {
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

            if (chrs[i] == '*' || chrs[i] == '/' || chrs[i] == '+' || chrs[i] == '-') {
                ops.add(chrs[i]);
            }  else {
                acc = acc * 10 + (chrs[i]-'0');
            }
        }

        while (ops.size() > 0) {
            int val1 = values.removeFirst();
            int val2 = values.removeFirst();
            char op = ops.removeFirst();
            if (op == '+') {
                values.add(val1+val2);
            }
            if (op == '-') {
                values.addFirst(val1-val2);
            }
        }
        return values.removeLast();
    }
    
}
