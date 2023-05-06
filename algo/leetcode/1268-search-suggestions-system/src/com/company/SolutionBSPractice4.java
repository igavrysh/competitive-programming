package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionBSPractice4 {
    public static void main(String[] args) {
        testSolutionBSPractice4_1();
        testSolutionBSPractice4_2();
        testSolutionBSPractice4_3();
        testSolutionBSPractice4_4();
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        int l = 0, r = products.length-1;
        List<List<String>> output = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> o = new ArrayList<>();
            l = bsLeft(l, r, i, products, searchWord);
            r = bsRight(l, r, i, products, searchWord);
            if (l<=r) {
                for (int j = 0; j < 3; j++) {
                    if (l+j<=r && l+j < products.length) {
                        o.add(products[l+j]);
                    }
                }
            }
            output.add(o);
        }
        return output;
    }

    private int bsLeft(int startL, int startR, int i, String[] products, String product) {
        int good = startR+1;
        int bad = startL-1; 
        while (good-bad > 1) {
            int m = bad + (good -bad) / 2;
            if (products[m].length() > i && products[m].charAt(i) >= product.charAt(i)) {
                good = m;
            }  else {
                bad = m;
            }
        }
        return good;
    }

    private int bsRight(int startL, int startR, int i, String[] products, String product) {
        int good = startR+1;
        int bad = startL-1; 
        while (good-bad > 1) {
            int m = bad + (good -bad) / 2;
            if (products[m].length() <= i || products[m].charAt(i) > product.charAt(i)) {
                good = m;
            }  else {
                bad = m;
            }
        }
        return good-1;
    }

    public static void testSolutionBSPractice4_1() {
        String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
        String searchWord = "mouse";
        SolutionBSPractice4 s = new SolutionBSPractice4();
        List<List<String>> output = s.suggestedProducts(products, searchWord);
        boolean passed = output.size() == 5
                && Arrays.deepEquals(output.get(0).toArray(), new String[] { "mobile", "moneypot", "monitor" })
                && Arrays.deepEquals(output.get(1).toArray(), new String[] { "mobile", "moneypot", "monitor" })
                && Arrays.deepEquals(output.get(2).toArray(), new String[] { "mouse", "mousepad" })
                && Arrays.deepEquals(output.get(3).toArray(), new String[] { "mouse", "mousepad" })
                && Arrays.deepEquals(output.get(4).toArray(), new String[] { "mouse", "mousepad" });
        System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBSPractice4_2() {
        String[] products = { "havana" };
        String searchWord = "havana";
        SolutionBSPractice4 s = new SolutionBSPractice4();
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

    public static void testSolutionBSPractice4_3() {
        String[] products = { "bags", "baggage", "banner", "box", "cloths" };
        String searchWord = "bags";
        SolutionBSPractice4 s = new SolutionBSPractice4();
        List<List<String>> output = s.suggestedProducts(products, searchWord);
        boolean passed = output.size() == 4
                && Arrays.deepEquals(output.get(0).toArray(), new String[] { "baggage", "bags", "banner" })
                && Arrays.deepEquals(output.get(1).toArray(), new String[] { "baggage", "bags", "banner" })
                && Arrays.deepEquals(output.get(2).toArray(), new String[] { "baggage", "bags" })
                && Arrays.deepEquals(output.get(3).toArray(), new String[] { "bags" });
        System.out.println(getMethodName() + ": " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBSPractice4_4() {
        String[] products = { "havana" };
        String searchWord = "tatiana";
        SolutionBSPractice4 s = new SolutionBSPractice4();
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
