package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        //testSolutionGraphBothSides1();
        //testSolutionGraphBothSides2();
        testSolutionGraphBothSides4();
        
        //testSolutionGraph1();
        //testSolutionGraph2();
        //testSolutionGraph3();
        //testSolutionGraph4();

        //testSolution1();
        //testSolution2();
        //testSolution3();
    }


    public static void testSolutionGraphBothSides1() {
        SolutionGraphBothSides s = new SolutionGraphBothSides();
        List<List<String>> actual = s.findLadders("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));
        String[][] expected = {{"hit","hot","dot","dog","cog"},{"hit","hot","lot","log","cog"}};
        boolean passed = compare2dArrayWithList(expected, actual);
        System.out.println("testSolutionGraphBothSides1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionGraphBothSides2() {
        SolutionGraphBothSides s = new SolutionGraphBothSides();
        List<List<String>> actual = s.findLadders("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log"}));
        String[][] expected = {};
        boolean passed = compare2dArrayWithList(expected, actual);
        System.out.println("testSolutionGraphBothSides2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionGraphBothSides4() {
        SolutionGraphBothSides s = new SolutionGraphBothSides();
        List<List<String>> actual = s.findLadders("red", "tax", Arrays.asList(new String[]{"ted","tex","red","tax","tad","den","rex","pee"}));
        String[][] expected = {{"red","ted","tad","tax"},{"red","ted","tex","tax"},{"red","rex","tex","tax"}};
        boolean passed = compare2dArrayWithList(expected, actual);
        System.out.println("testSolutionGraphBothSides4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionGraph1() {
        SolutionGraph s = new SolutionGraph();
        List<List<String>> actual = s.findLadders("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));
        String[][] expected = {{"hit","hot","dot","dog","cog"},{"hit","hot","lot","log","cog"}};
        boolean passed = compare2dArrayWithList(expected, actual);
        System.out.println("testSolutionGraph1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionGraph2() {
        SolutionGraph s = new SolutionGraph();
        List<List<String>> actual = s.findLadders("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log"}));
        String[][] expected = {};
        boolean passed = compare2dArrayWithList(expected, actual);
        System.out.println("testSolutionGraph2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionGraph4() {
        SolutionGraph s = new SolutionGraph();
        List<List<String>> actual = s.findLadders("red", "tax", Arrays.asList(new String[]{"ted","tex","red","tax","tad","den","rex","pee"}));
        String[][] expected = {{"red","ted","tad","tax"},{"red","ted","tex","tax"},{"red","rex","tex","tax"}};
        boolean passed = compare2dArrayWithList(expected, actual);
        System.out.println("testSolutionGraph4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1() {
        SolutionNaive s = new SolutionNaive();
        List<List<String>> actual = s.findLadders("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));
        String[][] expected = {{"hit","hot","dot","dog","cog"},{"hit","hot","lot","log","cog"}};
        boolean passed = compare2dArrayWithList(expected, actual);
        System.out.println("testSolution1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2() {
        SolutionNaive s = new SolutionNaive();
        List<List<String>> actual = s.findLadders("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log"}));
        String[][] expected = {};
        boolean passed = compare2dArrayWithList(expected, actual);
        System.out.println("testSolution2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution3() {
        String beginWord = "aaaaa";
        String endWord = "ggggg";
        List<String> wordList = Arrays.asList(new String[]{
            "aaaaa","caaaa","cbaaa","daaaa","dbaaa","eaaaa","ebaaa","faaaa","fbaaa","gaaaa","gbaaa","haaaa","hbaaa","iaaaa",
            "ibaaa","jaaaa","jbaaa","kaaaa","kbaaa","laaaa","lbaaa","maaaa","mbaaa","naaaa","nbaaa","oaaaa","obaaa","paaaa",
            "pbaaa","bbaaa","bbcaa","bbcba","bbdaa","bbdba","bbeaa","bbeba","bbfaa","bbfba","bbgaa","bbgba","bbhaa","bbhba",
            "bbiaa","bbiba","bbjaa","bbjba","bbkaa","bbkba","bblaa","bblba","bbmaa","bbmba","bbnaa","bbnba","bboaa","bboba",
            "bbpaa","bbpba","bbbba","abbba","acbba","dbbba","dcbba","ebbba","ecbba","fbbba","fcbba","gbbba","gcbba","hbbba",
            "hcbba","ibbba","icbba","jbbba","jcbba","kbbba","kcbba","lbbba","lcbba","mbbba","mcbba","nbbba","ncbba","obbba",
            "ocbba","pbbba","pcbba","ccbba","ccaba","ccaca","ccdba","ccdca","cceba","cceca","ccfba","ccfca","ccgba","ccgca",
            "cchba","cchca","cciba","ccica","ccjba","ccjca","cckba","cckca","cclba","cclca","ccmba","ccmca","ccnba","ccnca",
            "ccoba","ccoca","ccpba","ccpca","cccca","accca","adcca","bccca","bdcca","eccca","edcca","fccca","fdcca","gccca",
            "gdcca","hccca","hdcca","iccca","idcca","jccca","jdcca","kccca","kdcca","lccca","ldcca","mccca","mdcca","nccca",
            "ndcca","occca","odcca","pccca","pdcca","ddcca","ddaca","ddada","ddbca","ddbda","ddeca","ddeda","ddfca","ddfda",
            "ddgca","ddgda","ddhca","ddhda","ddica","ddida","ddjca","ddjda","ddkca","ddkda","ddlca","ddlda","ddmca","ddmda",
            "ddnca","ddnda","ddoca","ddoda","ddpca","ddpda","dddda","addda","aedda","bddda","bedda","cddda","cedda","fddda",
            "fedda","gddda","gedda","hddda","hedda","iddda","iedda","jddda","jedda","kddda","kedda","lddda","ledda","mddda",
            "medda","nddda","nedda","oddda","oedda","pddda","pedda","eedda","eeada","eeaea","eebda","eebea","eecda","eecea",
            "eefda","eefea","eegda","eegea","eehda","eehea","eeida","eeiea","eejda","eejea","eekda","eekea","eelda","eelea",
            "eemda","eemea","eenda","eenea","eeoda","eeoea","eepda","eepea","eeeea","ggggg","agggg","ahggg","bgggg","bhggg",
            "cgggg","chggg","dgggg","dhggg","egggg","ehggg","fgggg","fhggg","igggg","ihggg","jgggg","jhggg","kgggg","khggg",
            "lgggg","lhggg","mgggg","mhggg","ngggg","nhggg","ogggg","ohggg","pgggg","phggg","hhggg","hhagg","hhahg","hhbgg",
            "hhbhg","hhcgg","hhchg","hhdgg","hhdhg","hhegg","hhehg","hhfgg","hhfhg","hhigg","hhihg","hhjgg","hhjhg","hhkgg",
            "hhkhg","hhlgg","hhlhg","hhmgg","hhmhg","hhngg","hhnhg","hhogg","hhohg","hhpgg","hhphg","hhhhg","ahhhg","aihhg",
            "bhhhg","bihhg","chhhg","cihhg","dhhhg","dihhg","ehhhg","eihhg","fhhhg","fihhg","ghhhg","gihhg","jhhhg","jihhg",
            "khhhg","kihhg","lhhhg","lihhg","mhhhg","mihhg","nhhhg","nihhg","ohhhg","oihhg","phhhg","pihhg","iihhg","iiahg",
            "iiaig","iibhg","iibig","iichg","iicig","iidhg","iidig","iiehg","iieig","iifhg","iifig","iighg","iigig","iijhg",
            "iijig","iikhg","iikig","iilhg","iilig","iimhg","iimig","iinhg","iinig","iiohg","iioig","iiphg","iipig","iiiig",
            "aiiig","ajiig","biiig","bjiig","ciiig","cjiig","diiig","djiig","eiiig","ejiig","fiiig","fjiig","giiig","gjiig",
            "hiiig","hjiig","kiiig","kjiig","liiig","ljiig","miiig","mjiig","niiig","njiig","oiiig","ojiig","piiig","pjiig",
            "jjiig","jjaig","jjajg","jjbig","jjbjg","jjcig","jjcjg","jjdig","jjdjg","jjeig","jjejg","jjfig","jjfjg","jjgig",
            "jjgjg","jjhig","jjhjg","jjkig","jjkjg","jjlig","jjljg","jjmig","jjmjg","jjnig","jjnjg","jjoig","jjojg","jjpig",
            "jjpjg","jjjjg","ajjjg","akjjg","bjjjg","bkjjg","cjjjg","ckjjg","djjjg","dkjjg","ejjjg","ekjjg","fjjjg","fkjjg",
            "gjjjg","gkjjg","hjjjg","hkjjg","ijjjg","ikjjg","ljjjg","lkjjg","mjjjg","mkjjg","njjjg","nkjjg","ojjjg","okjjg",
            "pjjjg","pkjjg","kkjjg","kkajg","kkakg","kkbjg","kkbkg","kkcjg","kkckg","kkdjg","kkdkg","kkejg","kkekg","kkfjg",
            "kkfkg","kkgjg","kkgkg","kkhjg","kkhkg","kkijg","kkikg","kkljg","kklkg","kkmjg","kkmkg","kknjg","kknkg","kkojg",
            "kkokg","kkpjg","kkpkg","kkkkg","ggggx","gggxx","ggxxx","gxxxx","xxxxx","xxxxy","xxxyy","xxyyy","xyyyy","yyyyy",
            "yyyyw","yyyww","yywww","ywwww","wwwww","wwvww","wvvww","vvvww","vvvwz","avvwz","aavwz","aaawz","aaaaz"});
        SolutionNaive s = new SolutionNaive();
        List<List<String>> actual = s.findLadders(beginWord, endWord, wordList);
        String[][] expected = {};
        boolean passed = compare2dArrayWithList(expected, actual);
        System.out.println("testSolution3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionGraph3() {
        String beginWord = "aaaaa";
        String endWord = "ggggg";
        List<String> wordList = Arrays.asList(new String[]{
            "aaaaa","caaaa","cbaaa","daaaa","dbaaa","eaaaa","ebaaa","faaaa","fbaaa","gaaaa","gbaaa","haaaa","hbaaa","iaaaa",
            "ibaaa","jaaaa","jbaaa","kaaaa","kbaaa","laaaa","lbaaa","maaaa","mbaaa","naaaa","nbaaa","oaaaa","obaaa","paaaa",
            "pbaaa","bbaaa","bbcaa","bbcba","bbdaa","bbdba","bbeaa","bbeba","bbfaa","bbfba","bbgaa","bbgba","bbhaa","bbhba",
            "bbiaa","bbiba","bbjaa","bbjba","bbkaa","bbkba","bblaa","bblba","bbmaa","bbmba","bbnaa","bbnba","bboaa","bboba",
            "bbpaa","bbpba","bbbba","abbba","acbba","dbbba","dcbba","ebbba","ecbba","fbbba","fcbba","gbbba","gcbba","hbbba",
            "hcbba","ibbba","icbba","jbbba","jcbba","kbbba","kcbba","lbbba","lcbba","mbbba","mcbba","nbbba","ncbba","obbba",
            "ocbba","pbbba","pcbba","ccbba","ccaba","ccaca","ccdba","ccdca","cceba","cceca","ccfba","ccfca","ccgba","ccgca",
            "cchba","cchca","cciba","ccica","ccjba","ccjca","cckba","cckca","cclba","cclca","ccmba","ccmca","ccnba","ccnca",
            "ccoba","ccoca","ccpba","ccpca","cccca","accca","adcca","bccca","bdcca","eccca","edcca","fccca","fdcca","gccca",
            "gdcca","hccca","hdcca","iccca","idcca","jccca","jdcca","kccca","kdcca","lccca","ldcca","mccca","mdcca","nccca",
            "ndcca","occca","odcca","pccca","pdcca","ddcca","ddaca","ddada","ddbca","ddbda","ddeca","ddeda","ddfca","ddfda",
            "ddgca","ddgda","ddhca","ddhda","ddica","ddida","ddjca","ddjda","ddkca","ddkda","ddlca","ddlda","ddmca","ddmda",
            "ddnca","ddnda","ddoca","ddoda","ddpca","ddpda","dddda","addda","aedda","bddda","bedda","cddda","cedda","fddda",
            "fedda","gddda","gedda","hddda","hedda","iddda","iedda","jddda","jedda","kddda","kedda","lddda","ledda","mddda",
            "medda","nddda","nedda","oddda","oedda","pddda","pedda","eedda","eeada","eeaea","eebda","eebea","eecda","eecea",
            "eefda","eefea","eegda","eegea","eehda","eehea","eeida","eeiea","eejda","eejea","eekda","eekea","eelda","eelea",
            "eemda","eemea","eenda","eenea","eeoda","eeoea","eepda","eepea","eeeea","ggggg","agggg","ahggg","bgggg","bhggg",
            "cgggg","chggg","dgggg","dhggg","egggg","ehggg","fgggg","fhggg","igggg","ihggg","jgggg","jhggg","kgggg","khggg",
            "lgggg","lhggg","mgggg","mhggg","ngggg","nhggg","ogggg","ohggg","pgggg","phggg","hhggg","hhagg","hhahg","hhbgg",
            "hhbhg","hhcgg","hhchg","hhdgg","hhdhg","hhegg","hhehg","hhfgg","hhfhg","hhigg","hhihg","hhjgg","hhjhg","hhkgg",
            "hhkhg","hhlgg","hhlhg","hhmgg","hhmhg","hhngg","hhnhg","hhogg","hhohg","hhpgg","hhphg","hhhhg","ahhhg","aihhg",
            "bhhhg","bihhg","chhhg","cihhg","dhhhg","dihhg","ehhhg","eihhg","fhhhg","fihhg","ghhhg","gihhg","jhhhg","jihhg",
            "khhhg","kihhg","lhhhg","lihhg","mhhhg","mihhg","nhhhg","nihhg","ohhhg","oihhg","phhhg","pihhg","iihhg","iiahg",
            "iiaig","iibhg","iibig","iichg","iicig","iidhg","iidig","iiehg","iieig","iifhg","iifig","iighg","iigig","iijhg",
            "iijig","iikhg","iikig","iilhg","iilig","iimhg","iimig","iinhg","iinig","iiohg","iioig","iiphg","iipig","iiiig",
            "aiiig","ajiig","biiig","bjiig","ciiig","cjiig","diiig","djiig","eiiig","ejiig","fiiig","fjiig","giiig","gjiig",
            "hiiig","hjiig","kiiig","kjiig","liiig","ljiig","miiig","mjiig","niiig","njiig","oiiig","ojiig","piiig","pjiig",
            "jjiig","jjaig","jjajg","jjbig","jjbjg","jjcig","jjcjg","jjdig","jjdjg","jjeig","jjejg","jjfig","jjfjg","jjgig",
            "jjgjg","jjhig","jjhjg","jjkig","jjkjg","jjlig","jjljg","jjmig","jjmjg","jjnig","jjnjg","jjoig","jjojg","jjpig",
            "jjpjg","jjjjg","ajjjg","akjjg","bjjjg","bkjjg","cjjjg","ckjjg","djjjg","dkjjg","ejjjg","ekjjg","fjjjg","fkjjg",
            "gjjjg","gkjjg","hjjjg","hkjjg","ijjjg","ikjjg","ljjjg","lkjjg","mjjjg","mkjjg","njjjg","nkjjg","ojjjg","okjjg",
            "pjjjg","pkjjg","kkjjg","kkajg","kkakg","kkbjg","kkbkg","kkcjg","kkckg","kkdjg","kkdkg","kkejg","kkekg","kkfjg",
            "kkfkg","kkgjg","kkgkg","kkhjg","kkhkg","kkijg","kkikg","kkljg","kklkg","kkmjg","kkmkg","kknjg","kknkg","kkojg",
            "kkokg","kkpjg","kkpkg","kkkkg","ggggx","gggxx","ggxxx","gxxxx","xxxxx","xxxxy","xxxyy","xxyyy","xyyyy","yyyyy",
            "yyyyw","yyyww","yywww","ywwww","wwwww","wwvww","wvvww","vvvww","vvvwz","avvwz","aavwz","aaawz","aaaaz"});
        SolutionGraph s = new SolutionGraph();
        List<List<String>> actual = s.findLadders(beginWord, endWord, wordList);
        String[][] expected = {};
        boolean passed = compare2dArrayWithList(expected, actual);
        System.out.println("testSolutionGraph3: " + (passed ? "passed" : "failed"));
    }

    private static boolean compare2dArrayWithList(String[][] arr, List<List<String>> list) {
        if (arr.length != list.size()) {
            return false;
        }

        String[][] arr1 = arr;
        String[][] arr2 = new String[list.size()][];
        List<String[]> interim = list.stream()
            .map(l -> { 
                String[] a = new String[l.size()];
                l.toArray(a);
                return a;
            })
            .collect(Collectors.toList());
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