package com.company;

class Main {
    public static void main(String[] args) {
        testTimeMap1_1();
        testTimeMap1_2();
    }

    public static void testTimeMap1_1() {
        boolean passed = true;
        TimeMap M = new TimeMap();
        M.set("foo", "bar", 1);
        passed = passed && M.get("foo", 1).equals("bar");
        passed = passed && M.get("foo", 3).equals("bar");
        M.set("foo", "bar2", 4);
        passed = passed && M.get("foo", 4).equals("bar2");
        passed = passed && M.get("foo", 5).equals("bar2");
        System.out.println("testTimeMap1_1:" + (passed ? "passed" : "failed"));
    }

    public static void testTimeMap1_2() {
        boolean passed = true;
        TimeMap M = new TimeMap();
        M.set("love", "high", 10);
        M.set("love", "low", 20);
        passed = passed && M.get("love", 5).equals("");
        passed = passed && M.get("love", 10).equals("high");
        passed = passed && M.get("love", 15).equals("high");
        passed = passed && M.get("love", 20).equals("low");
        passed = passed && M.get("love", 25).equals("low");

        System.out.println("testTimeMap1_2:" + (passed ? "passed" : "failed"));
    }
}

/*
["TimeMap", "set",              "set",              "get",      "get",      "get",      "get",      "get"]
[[],        ["love","high",10], ["love","low",20],  ["love",5], ["love",10],["love",15],["love",20],["love",25]]
49 / 50 testcases passed
Output
[null,null,null,"","high","low","low","low"]
Expected
[null,null,null,"","high","high","low","low"]
 */