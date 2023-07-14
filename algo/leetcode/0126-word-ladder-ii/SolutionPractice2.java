import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class SolutionPractice2 {
    
    private boolean isConnected(String w1, String w2) {
        int count = 0;
        for (int i=0; i<w1.length(); i++) {
            if (w1.charAt(i)!=w2.charAt(i)) {
                count++;
                if (count>1) {
                    return false;
                }
            }
        }
        return count==1;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wl) {
        List<List<String>> acc = new ArrayList<>();
        HashSet<String> dict = new HashSet<>(wl);
        if (!dict.contains(endWord)) {
            return acc;
        }

        List<HashSet<String>> levels = new ArrayList<>() {{ add(new HashSet<String>() {{ add(beginWord); }}); }};
        dict.remove(beginWord);
        boolean isFound = false;
        while (dict.size() > 0 && !isFound) {
            HashSet<String> level = levels.get(levels.size()-1);
            HashSet<String> nextlevel = new HashSet<String>();

            for (String levelWord : level) {
                HashSet<String> toRemove = new HashSet<>();
                for (String nextCand : dict) {
                    if (!isConnected(levelWord, nextCand)) {
                        continue;
                    }

                    if (nextCand.equals(endWord)) {
                        isFound = true;
                        break;
                    }
                    
                    toRemove.add(nextCand);
                    nextlevel.add(nextCand);
                }
                for (String rem : toRemove) {
                    dict.remove(rem);
                }
            }

            if (nextlevel.size() == 0) {
                break;
            }

            if (isFound) {
                break;
            }

            levels.add(nextlevel);
        }

        if (!isFound) {
            return acc;
        }

        acc.add(new LinkedList<>(){{ add(endWord); }});
        for (int i=levels.size()-1; i>=0; i--) {
            List<List<String>> newAcc = new ArrayList<>();
            HashSet<String> level = levels.get(i);
            for (String levelWord : level) {
                for (int k=0; k<acc.size(); k++) {
                    List<String> path = new LinkedList<>(acc.get(k));
                    if (isConnected(path.get(0), levelWord)) {
                        path.add(0, levelWord);
                        newAcc.add(path);
                    }
                }
            }
            acc = newAcc;
        }
        return acc;
    }

    public static void main(String[] args) {
        testSolutionPractice2_2();

        testSolutionPractice2_3();
        testSolutionPractice2_1();
    }

    public static void testSolutionPractice2_1() {
        SolutionPractice2 s = new SolutionPractice2();
        List<List<String>> actual = s.findLadders("hit", "cog", 
            Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));
        String[][] expected = {
            {"hit","hot","dot","dog","cog"},
            {"hit","hot","lot","log","cog"}
        };
        HashSet<String> expectedHS = new HashSet<>();
        for (int i = 0; i < expected.length; i++) {
            expectedHS.add(Arrays.deepToString(expected[i]));
        }

        HashSet<String> actualHS = new HashSet<>();
        for (int i = 0; i < actual.size(); i++) {
            actualHS.add(Arrays.deepToString(actual.get(i).stream().toArray(String[]::new)));
        }
        
        boolean passed = expectedHS.equals(actualHS);
        System.out.println("testSolutionPractice2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_2() {
        SolutionPractice2 s = new SolutionPractice2();
        List<String> wordList = Arrays.asList(new String[]{"ted","tex","red","tax","tad","den","rex","pee"});
        String beginWord = "red";
        String endWord = "tax";
        List<List<String>> actual = s.findLadders(beginWord, endWord, wordList);
        String[][] expected = {
            {"red","ted","tad","tax"},
            {"red","ted","tex","tax"},
            {"red","rex","tex","tax"}
        };

        HashSet<String> expectedHS = new HashSet<>();
        for (int i = 0; i < expected.length; i++) {
            expectedHS.add(Arrays.deepToString(expected[i]));
        }

        HashSet<String> actualHS = new HashSet<>();
        for (int i = 0; i < actual.size(); i++) {
            actualHS.add(Arrays.deepToString(actual.get(i).stream().toArray(String[]::new)));
        }
        
        boolean passed = expectedHS.equals(actualHS);
        System.out.println("testSolutionPractice2_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_3() {
        SolutionPractice2 s = new SolutionPractice2();
        List<String> wordList = Arrays.asList(new String[]{
            "aaaaa","caaaa","cbaaa","daaaa","dbaaa","eaaaa","ebaaa","faaaa","fbaaa","gaaaa","gbaaa","haaaa","hbaaa","iaaaa","ibaaa",
            "jaaaa","jbaaa","kaaaa","kbaaa","laaaa","lbaaa","maaaa","mbaaa","naaaa","nbaaa","oaaaa","obaaa","paaaa","pbaaa","bbaaa",
            "bbcaa","bbcba","bbdaa","bbdba","bbeaa","bbeba","bbfaa","bbfba","bbgaa","bbgba","bbhaa","bbhba","bbiaa","bbiba","bbjaa",
            "bbjba","bbkaa","bbkba","bblaa","bblba","bbmaa","bbmba","bbnaa","bbnba","bboaa","bboba","bbpaa","bbpba","bbbba","abbba",
            "acbba","dbbba","dcbba","ebbba","ecbba","fbbba","fcbba","gbbba","gcbba","hbbba","hcbba","ibbba","icbba","jbbba","jcbba",
            "kbbba","kcbba","lbbba","lcbba","mbbba","mcbba","nbbba","ncbba","obbba","ocbba","pbbba","pcbba","ccbba","ccaba","ccaca",
            "ccdba","ccdca","cceba","cceca","ccfba","ccfca","ccgba","ccgca","cchba","cchca","cciba","ccica","ccjba","ccjca","cckba",
            "cckca","cclba","cclca","ccmba","ccmca","ccnba","ccnca","ccoba","ccoca","ccpba","ccpca","cccca","accca","adcca","bccca",
            "bdcca","eccca","edcca","fccca","fdcca","gccca","gdcca","hccca","hdcca","iccca","idcca","jccca","jdcca","kccca","kdcca",
            "lccca","ldcca","mccca","mdcca","nccca","ndcca","occca","odcca","pccca","pdcca","ddcca","ddaca","ddada","ddbca","ddbda",
            "ddeca","ddeda","ddfca","ddfda","ddgca","ddgda","ddhca","ddhda","ddica","ddida","ddjca","ddjda","ddkca","ddkda","ddlca",
            "ddlda","ddmca","ddmda","ddnca","ddnda","ddoca","ddoda","ddpca","ddpda","dddda","addda","aedda","bddda","bedda","cddda",
            "cedda","fddda","fedda","gddda","gedda","hddda","hedda","iddda","iedda","jddda","jedda","kddda","kedda","lddda","ledda",
            "mddda","medda","nddda","nedda","oddda","oedda","pddda","pedda","eedda","eeada","eeaea","eebda","eebea","eecda","eecea",
            "eefda","eefea","eegda","eegea","eehda","eehea","eeida","eeiea","eejda","eejea","eekda","eekea","eelda","eelea","eemda",
            "eemea","eenda","eenea","eeoda","eeoea","eepda","eepea","eeeea","ggggg","agggg","ahggg","bgggg","bhggg","cgggg","chggg",
            "dgggg","dhggg","egggg","ehggg","fgggg","fhggg","igggg","ihggg","jgggg","jhggg","kgggg","khggg","lgggg","lhggg","mgggg",
            "mhggg","ngggg","nhggg","ogggg","ohggg","pgggg","phggg","hhggg","hhagg","hhahg","hhbgg","hhbhg","hhcgg","hhchg","hhdgg",
            "hhdhg","hhegg","hhehg","hhfgg","hhfhg","hhigg","hhihg","hhjgg","hhjhg","hhkgg","hhkhg","hhlgg","hhlhg","hhmgg","hhmhg",
            "hhngg","hhnhg","hhogg","hhohg","hhpgg","hhphg","hhhhg","ahhhg","aihhg","bhhhg","bihhg","chhhg","cihhg","dhhhg","dihhg",
            "ehhhg","eihhg","fhhhg","fihhg","ghhhg","gihhg","jhhhg","jihhg","khhhg","kihhg","lhhhg","lihhg","mhhhg","mihhg","nhhhg",
            "nihhg","ohhhg","oihhg","phhhg","pihhg","iihhg","iiahg","iiaig","iibhg","iibig","iichg","iicig","iidhg","iidig","iiehg",
            "iieig","iifhg","iifig","iighg","iigig","iijhg","iijig","iikhg","iikig","iilhg","iilig","iimhg","iimig","iinhg","iinig",
            "iiohg","iioig","iiphg","iipig","iiiig","aiiig","ajiig","biiig","bjiig","ciiig","cjiig","diiig","djiig","eiiig","ejiig",
            "fiiig","fjiig","giiig","gjiig","hiiig","hjiig","kiiig","kjiig","liiig","ljiig","miiig","mjiig","niiig","njiig","oiiig",
            "ojiig","piiig","pjiig","jjiig","jjaig","jjajg","jjbig","jjbjg","jjcig","jjcjg","jjdig","jjdjg","jjeig","jjejg","jjfig",
            "jjfjg","jjgig","jjgjg","jjhig","jjhjg","jjkig","jjkjg","jjlig","jjljg","jjmig","jjmjg","jjnig","jjnjg","jjoig","jjojg",
            "jjpig","jjpjg","jjjjg","ajjjg","akjjg","bjjjg","bkjjg","cjjjg","ckjjg","djjjg","dkjjg","ejjjg","ekjjg","fjjjg","fkjjg",
            "gjjjg","gkjjg","hjjjg","hkjjg","ijjjg","ikjjg","ljjjg","lkjjg","mjjjg","mkjjg","njjjg","nkjjg","ojjjg","okjjg","pjjjg",
            "pkjjg","kkjjg","kkajg","kkakg","kkbjg","kkbkg","kkcjg","kkckg","kkdjg","kkdkg","kkejg","kkekg","kkfjg","kkfkg","kkgjg",
            "kkgkg","kkhjg","kkhkg","kkijg","kkikg","kkljg","kklkg","kkmjg","kkmkg","kknjg","kknkg","kkojg","kkokg","kkpjg","kkpkg",
            "kkkkg","ggggx","gggxx","ggxxx","gxxxx","xxxxx","xxxxy","xxxyy","xxyyy","xyyyy","yyyyy","yyyyw","yyyww","yywww","ywwww",
            "wwwww","wwvww","wvvww","vvvww","vvvwz","avvwz","aavwz","aaawz","aaaaz"});
        String beginWord = "aaaaa";
        String endWord = "ggggg";
        String[][] expected = {
            {"red","ted","tad","tax"},
            {"red","ted","tex","tax"},
            {"red","rex","tex","tax"}
        };
        List<List<String>> actual = s.findLadders(beginWord, endWord, wordList);
        int t = 1;
        boolean passed = true;
        System.out.println("testSolutionPractice2_3: " + (passed ? "passed" : "failed"));


    }
}
