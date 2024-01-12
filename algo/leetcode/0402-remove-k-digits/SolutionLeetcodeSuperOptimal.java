public class SolutionLeetcodeSuperOptimal {
    public String removeKdigits(String num, int k) {
        char[] symbols = num.toCharArray();
        if (symbols.length == k) {
            return "0";
        }
        int length = symbols.length - k;
        char[] stack = new char[length];
        int pos = 0;
        for (int i = 0; i < symbols.length; i++) {
            while (pos > 0 && stack[pos - 1] > symbols[i] && (pos + symbols.length - i > length)) {
                pos--;
            }
            if (pos < length) {
                stack[pos++] = symbols[i];
            }
        }
        int leadingZeroes = 0;
        while (leadingZeroes < length && stack[leadingZeroes] == '0') {
            leadingZeroes++;
        }
        return leadingZeroes == length ? "0" : new String(stack, leadingZeroes, length - leadingZeroes);
    }
}
