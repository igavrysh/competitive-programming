package com.company;

public class Main {

    public static void test1() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        boolean passed = true;
        passed = passed && wordDictionary.search("pad") == false; // return False
        passed = passed && wordDictionary.search("bad") == true; // return True
        passed = passed && wordDictionary.search(".ad") == true; // return True
        passed = passed && wordDictionary.search("b..") == true; // return True
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");

        boolean passed = true;
        passed = passed && wordDictionary.search("a") == false; // return False
        passed = passed && wordDictionary.search(".at") == false; // return True
        wordDictionary.addWord("bat");
        passed = passed && wordDictionary.search(".at") == true; // return True
        passed = passed && wordDictionary.search("an.") == true; // return True
        passed = passed && wordDictionary.search("a.d.") == false; // return True
        passed = passed && wordDictionary.search("b.") == false; // return True
        passed = passed && wordDictionary.search("a.d") == true; // return True
        passed = passed && wordDictionary.search(".") == false; // return True
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("ran");
        wordDictionary.addWord("rune");
        wordDictionary.addWord("runner");
        wordDictionary.addWord("runs");
        wordDictionary.addWord("add");
        wordDictionary.addWord("adds");
        wordDictionary.addWord("adder");
        wordDictionary.addWord("addee");

        boolean passed = true;
        passed = passed && wordDictionary.search("r.n") == true; // return True
        passed = passed && wordDictionary.search("ru.n.e") == false; // return True
        passed = passed && wordDictionary.search("add") == true; // return True
        passed = passed && wordDictionary.search("add.") == true; // return True
        passed = passed && wordDictionary.search("adde.") == true; // return True
        passed = passed && wordDictionary.search(".an.") == false; // return True
        passed = passed && wordDictionary.search("...s") == true; // return True
        passed = passed && wordDictionary.search("....e.") == true; // return True
        passed = passed && wordDictionary.search(".......") == false; // return True
        passed = passed && wordDictionary.search("..n.r") == false; // return True
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
