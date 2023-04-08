class Main {

    public static void main(String[] args) {
        testMapSumHashMap3();

        testMapSumTrie1();
        testMapSumTrie2();
        testMapSumTrie3();
    }

    public static void testMapSumTrie1() {
        boolean passed = true;
        MapSumTrie mapSum = new MapSumTrie();
        mapSum.insert("apple", 3);  
        passed = passed && mapSum.sum("ap") == 3;           // return 3 (apple = 3)
        mapSum.insert("app", 2);    
        passed = passed && mapSum.sum("ap") == 5;           // return 5 (apple + app = 3 + 2 = 5)
        System.out.println("testMapSumTrie1: " + (passed ? "passed" : "failed"));
    }

    public static void testMapSumTrie2() {
        boolean passed = true;
        MapSumTrie mapSum = new MapSumTrie();
        mapSum.insert("a", 3);  
        passed = passed && mapSum.sum("ap") == 0;
        mapSum.insert("b", 2);    
        passed = passed && mapSum.sum("a") == 3;
        System.out.println("testMapSumTrie2: " + (passed ? "passed" : "failed"));
    }

    public static void testMapSumTrie3() {
        boolean passed = true;
        int output = 0;
        MapSumTrie mapSum = new MapSumTrie();
        mapSum.insert("apple", 3);  
        output = mapSum.sum("ap");
        passed = passed && output == 3;
        mapSum.insert("app", 2);
        mapSum.insert("apple", 2); 
        output = mapSum.sum("ap");
        passed = passed && output == 4;
        System.out.println("testMapSumTrie3: " + (passed ? "passed" : "failed"));
    }

    public static void testMapSumHashMap3() {
        boolean passed = true;
        int output = 0;
        MapSumHashMap mapSum = new MapSumHashMap();
        mapSum.insert("apple", 3);
        output = mapSum.sum("ap");
        passed = passed && output == 3;
        mapSum.insert("app", 2);
        mapSum.insert("apple", 2); 
        output = mapSum.sum("ap");
        passed = passed && output == 4;
        System.out.println("testMapSumHashMap3: " + (passed ? "passed" : "failed"));
    }
}

