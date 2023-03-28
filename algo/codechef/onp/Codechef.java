/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {

    public static void main (String[] args) throws IOException {

        /*
        testCodechef1(); 
        */

		String[] input = readInput();
        Codechef codechef = new Codechef();
        String[] output = codechef.rpnConvert(input);
        writeOutput(output);
	}

    private String[] rpnConvert(String[] input) {
        String[] output = new String[input.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = rpn(input[i]);
        }
        return output;
    }

    private String rpn(String str) {
        Deque<String> ops = new ArrayDeque<>();
        Deque<String> operands  = new ArrayDeque<>();

        char[] chrs = str.toCharArray();
        for (int i = 0; i < chrs.length; i++) {
            char chr = chrs[i];
            if (chr == '(') {
                continue;
            }

            if (chr == ')') {
                String op2 = operands.pop();
                String op1 = operands.pop();
                String op = ops.pop();
                StringBuilder sb = new StringBuilder();
                sb.append(op1);
                sb.append(op2);
                sb.append(op);
                operands.push(sb.toString());
                continue;
            }

            if (chr == '+' || chr == '-' || chr == '*' || chr == '/' || chr == '^') {
                ops.push(String.valueOf(chr));
                continue;
            }

            if (chr-'a' >= 0 && chr-'z' <= 0) {
                operands.push(String.valueOf(chr));
                continue;
            }

            throw new RuntimeException("unexpected point reached");
        }

        return !ops.isEmpty() || operands.size() != 1 ? null : operands.pop();
    }

    public static void testCodechef1() {
        Codechef codechef = new Codechef();
        String[] input = new String[]{
            "(a+(b*c))",
            "((a+b)*(z+x))",
            "((a+t)*((b+(a+c))^(c+d)))"
        };
        String[] output = codechef.rpnConvert(input);
        String[] expectedOutput = new String[]{"abc*+", "ab+zx+*", "at+bac++cd+^*"};
        boolean passed = Arrays.deepEquals(output, expectedOutput);
        System.out.println("testCodechef1: " + (passed ? "passed" : "failed"));
    }

    private static String[] readInput() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLineStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int n = Integer.parseInt(firstLineStr[0]);
            String[] input = new String[n];    
            int i = 0;
            while (i<n) {
                input[i] = bufferedReader.readLine().replaceAll("\\s+$", "");
                i++; 
            }
            return input;
        }
    }

    private static void writeOutput(String[] output) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int i = 0; i < output.length; i++) {
                String outputStr = String.valueOf(output[i]);
                bufferedWriter.write(outputStr);
                bufferedWriter.newLine();
            }
        }
    }
}
