import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class SolutionPractice {
    
    private String mask(int i, String s) {
        return s.substring(0, i) + "*" + s.substring(i+1, s.length());
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wl) {
        List<List<String>> acc = new ArrayList<>();
        if (beginWord.equals(endWord)) {
            acc.add(new ArrayList<String>(){{ add(beginWord); }});
            return acc;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (String word : wl) {
            for (int i = 0; i < word.length(); i++) {
                String mask = mask(i, word);
                List<String> l = map.getOrDefault(mask, new ArrayList<>());
                l.add(word);
                map.put(mask, l);
            }
        }

        boolean found = false;
        for (int i = 0; i < wl.size(); i++) {
            if (wl.get(i).equals(endWord)) {
                found = true;
                break;
            }
        }
        if (!found) {
            return acc;
        }

        Queue<ArrayList<String>> qB = new ArrayDeque<>();
        Queue<HashSet<String>> visited = new ArrayDeque<>();
        qB.add(new ArrayList<>(){{ add(beginWord); }});
        visited.add(new HashSet<>(){{ add(beginWord); }});


        int minPathSize = Integer.MAX_VALUE;
        while (qB.size() > 0) {
            int lQB = qB.size();
            for (int i = 0; i < lQB; i++) {
                ArrayList<String> path = qB.poll();
                HashSet<String> vis = visited.poll();

                String word = path.get(path.size()-1);
                for (int j = 0; j < word.length(); j++) {
                    String mask = mask(j, word);
                    List<String> l = map.get(mask);
                    if (l == null) {
                        continue;
                    }
                    
                    for (int k = 0; k < l.size(); k++) {
                        String child = l.get(k);
                        if (vis.contains(child)) {
                            continue;
                        }

                        ArrayList<String> pathToOffer = new ArrayList<>(path);
                        HashSet<String> visToOffer = new HashSet<>(vis);
                        pathToOffer.add(child);
                        visToOffer.add(child);

                        if (child.equals(endWord)) {
                            minPathSize = Math.min(minPathSize, pathToOffer.size());

                            if (pathToOffer.size() == minPathSize) {
                                acc.add(pathToOffer);
                            }
                        } else {
                            qB.offer(pathToOffer);
                            visited.add(visToOffer);
                        }                
                    }
                }
            }
        }

        return acc;
    }
    

    public static void main(String[] args) {
        testSolutionPractice_1();
        testSolutionPractice_2();
    }

    public static void testSolutionPractice_1() {
        SolutionPractice s = new SolutionPractice();
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

    public static void testSolutionPractice_2() {
        SolutionPractice s = new SolutionPractice();
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
}
