package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionBSPractice3 {

    public static void main(String[] args) {
        testSolutionBSPractice3_1();
        testSolutionBSPractice3_2();
        testSolutionBSPractice3_3();
        testSolutionBSPractice3_4();
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> output = new ArrayList<>();
        int idx = 0;
        boolean globalMatch = true;
        for (int i = 1; i <= searchWord.length(); i++) {
            List<String> o = new ArrayList<>();

            if (globalMatch) {
                idx = bs(products, searchWord.substring(0, i), idx);
                if (idx >= 0 && idx < products.length) {
                    globalMatch = matchPrefix(products[idx], searchWord, i);
                    if (globalMatch) {
                        o.add(products[idx]);
                        int delta = 1;
                        while (idx+delta < products.length && delta < 3) {
                            String candidate = products[idx+delta];
                            if (!matchPrefix(candidate, searchWord, i)) {
                                break;
                            }
                            o.add(candidate);
                            delta++;
                        }
                    } 
                }
            }
            output.add(o);            
        }
        return output;
    }

    private boolean matchPrefix(String product, String searchWord, int end) {
        if (end > searchWord.length() || end > product.length()) {
            return false;
        }
        for (int i = 0; i < end; i++) {
            if (product.charAt(i) != searchWord.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private int bs(String[] products, String search, int startIndex) {
        int bad = startIndex-1, good = products.length;
        while (good-bad > 1) {
            int m = bad + (good-bad) / 2;
            int res = products[m].compareTo(search);
            if (res <= -1) {
                bad = m;
            } else {
                good = m;
            }
        }
        return good;
    }

    public static void testSolutionBSPractice3_1() {
        String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
        String searchWord = "mouse";
        SolutionBSPractice3 s = new SolutionBSPractice3();
        List<List<String>> output = s.suggestedProducts(products, searchWord);
        boolean passed = output.size() == 5
                && Arrays.deepEquals(output.get(0).toArray(), new String[] { "mobile", "moneypot", "monitor" })
                && Arrays.deepEquals(output.get(1).toArray(), new String[] { "mobile", "moneypot", "monitor" })
                && Arrays.deepEquals(output.get(2).toArray(), new String[] { "mouse", "mousepad" })
                && Arrays.deepEquals(output.get(3).toArray(), new String[] { "mouse", "mousepad" })
                && Arrays.deepEquals(output.get(4).toArray(), new String[] { "mouse", "mousepad" });
        System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBSPractice3_2() {
        String[] products = { "havana" };
        String searchWord = "havana";
        SolutionBSPractice3 s = new SolutionBSPractice3();
        List<List<String>> output = s.suggestedProducts(products, searchWord);
        boolean passed = output.size() == 6
                && Arrays.deepEquals(output.get(0).toArray(), new String[] { "havana" })
                && Arrays.deepEquals(output.get(1).toArray(), new String[] { "havana" })
                && Arrays.deepEquals(output.get(2).toArray(), new String[] { "havana" })
                && Arrays.deepEquals(output.get(3).toArray(), new String[] { "havana" })
                && Arrays.deepEquals(output.get(4).toArray(), new String[] { "havana" })
                && Arrays.deepEquals(output.get(5).toArray(), new String[] { "havana" });
        System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBSPractice3_3() {
        String[] products = { "bags", "baggage", "banner", "box", "cloths" };
        String searchWord = "bags";
        SolutionBSPractice3 s = new SolutionBSPractice3();
        List<List<String>> output = s.suggestedProducts(products, searchWord);
        boolean passed = output.size() == 4
                && Arrays.deepEquals(output.get(0).toArray(), new String[] { "baggage", "bags", "banner" })
                && Arrays.deepEquals(output.get(1).toArray(), new String[] { "baggage", "bags", "banner" })
                && Arrays.deepEquals(output.get(2).toArray(), new String[] { "baggage", "bags" })
                && Arrays.deepEquals(output.get(3).toArray(), new String[] { "bags" });
        System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBSPractice3_4() {
        String[] products = { "havana" };
        String searchWord = "tatiana";
        SolutionBSPractice3 s = new SolutionBSPractice3();
        List<List<String>> output = s.suggestedProducts(products, searchWord);
        boolean passed = output.size() == 7
                && Arrays.deepEquals(output.get(0).toArray(), new String[] {})
                && Arrays.deepEquals(output.get(1).toArray(), new String[] {})
                && Arrays.deepEquals(output.get(2).toArray(), new String[] {})
                && Arrays.deepEquals(output.get(3).toArray(), new String[] {})
                && Arrays.deepEquals(output.get(4).toArray(), new String[] {})
                && Arrays.deepEquals(output.get(5).toArray(), new String[] {})
                && Arrays.deepEquals(output.get(6).toArray(), new String[] {});
        System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
    }

    public static String getMethodName() {
        return new Throwable()
                .getStackTrace()[1]
                .getMethodName();
    }
}
