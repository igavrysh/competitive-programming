package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        testSolution1();
    }

    public static void testSolution1() {
        Solution s = new Solution();
        List<List<String>> output = s.findLadders("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));
        String[][] expected = {{"hit","hot","dot","dog","cog"},{"hit","hot","lot","log","cog"}};
        boolean passed = compare2dArrayWithList(expected, output);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    private static boolean compare2dArrayWithList(String[][] arr, List<List<String>> l) {
        if (arr.length != l.size()) {
            return false;
        }

        String[][] arr1 = arr;
        String[][] arr2 = new String[l.size()][];




        
        List<String[]> interim = l.stream().map(list -> list.toArray()).map(o -> (String[])o).collect(Collectors.toList());
        interim.toArray(arr2);

        boolean equals = true;
        for (int i = 0; i < arr1.length; i++) {
            boolean found = false;
            for (int j = 0; j < arr2.length; j++) {
                if (Arrays.deepEquals(arr1[i], arr2[j])) {
                    found = true;
                }
            }
            if (found == false) {
                equals = false;
                break;
            }
        }

        return equals;
    }
}