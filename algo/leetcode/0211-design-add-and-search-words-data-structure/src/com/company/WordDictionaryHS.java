package com.company;

import java.util.HashSet;

public class WordDictionaryHS {
    private HashSet<String> words;
    
    public WordDictionaryHS() {
        words = new HashSet<>();
    }

    public void addWord(String word) {
        words.add(word);
        char[] chrs = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char tmp1 = chrs[i];
            chrs[i] = '.';
            String c1 = new String(chrs);
            words.add(c1);
            for (int j = i+1; j < word.length(); j++) {
                char tmp2 = chrs[j];
                chrs[j] = '.';
                String c2 = new String(chrs);
                words.add(c2);
                chrs[j] = tmp2;
            }
            chrs[i] = tmp1;
        }

        if (word.equals("qsibzxaorktypkfg")) {
            boolean tmp = words.contains("qsibz.aorkty.kfg");
            int tmp1=1;
        }

    }

    public boolean search(String word) {
        return words.contains(word);
    }


    public static void main(String[] args) {
        //testWordDictionaryHS_1();
        //testWordDictionaryHS_2();
        //testWordDictionaryHS_3();
        testWordDictionaryHS_4();
    }

    public static void testWordDictionaryHS_1() {
        WordDictionaryHS wordDictionary = new WordDictionaryHS();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        boolean passed = true;
        passed = passed && wordDictionary.search("pad") == false; // return False
        passed = passed && wordDictionary.search("bad") == true; // return True
        passed = passed && wordDictionary.search(".ad") == true; // return True
        passed = passed && wordDictionary.search("b..") == true; // return True
        System.out.println("testWordDictionaryHS_1: " + (passed ? "passed" : "failed"));
    }

    public static void testWordDictionaryHS_2() {
        WordDictionaryHS wordDictionary = new WordDictionaryHS();
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
        System.out.println("testWordDictionaryHS_2: " + (passed ? "passed" : "failed"));
    }

    public static void testWordDictionaryHS_3() {
        WordDictionaryHS wordDictionary = new WordDictionaryHS();
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
        System.out.println("testWordDictionaryHS_3: " + (passed ? "passed" : "failed"));
    }

    public static void testWordDictionaryHS_4() {
        String[] ops = {"WordDictionary","addWord","addWord","addWord","search","search","addWord","search","addWord","search"};
        String[] operands = {"","xgvk","wykzbvwdsoyfowqicymzd","xajbtjyjuwgoynjgu","wykzbvwdso..owqicymzd","..ha","qsibzxaorktypkfg","xgvk","vbycuvrkbcq","qsibz.aorkty.kfg"};
        Boolean[] expOutput = {null,null,null,null,true,false,null,true,null,true};
        WordDictionaryHS d = new WordDictionaryHS();
        boolean passed = true;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("WordDictionary")) {
                d = new WordDictionaryHS();
            } else if (ops[i].equals("addWord")) {
                d.addWord(operands[i]);
            } else if (ops[i].equals("search")) {
                passed = passed && ((Boolean)d.search(operands[i])).equals(expOutput);
            }
        }

        System.out.println("testWordDictionaryHS_4: " + (passed ? "passed" : "failed"));
    }


}
