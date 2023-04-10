import java.util.ArrayList;
import java.util.List;

public class SolutionTrie {

    private Node root = new Node();

    public List<List<Integer>> palindromePairs(String[] words) {
        for (int i = 0; i < words.length; i++) {
            char[] w = words[i].toCharArray();
            Node node = root;
            for (int j = 0; j < w.length; i++) {
                if (node.children[w[j]-'a'] == null) {
                    node.children[w[j]-'a'] = new Node();
                }
                if (isPalindrome(w, j, w.length-1)) {
                    node.polindromes.add(i);
                }
                node = node.children[w[j]-'a'];
            }
            // ! Even empty lines will get index, if they exist in input array words
            node.idx = i;
        }


        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            char[] w = words[i].toCharArray();

            for (int j = 0; j < w.length; j++) {
                
            }

        }


        return null;
    }

    private boolean isPalindrome(char[] chrs, int left, int right) {
        for (int i = 0; i < (right-left+1)/2; i++) {
            if (chrs[left+i] != chrs[right-i]) {
                return false;
            }
        }
        return true;
    }
    
    private List<Integer> pair(int i1, int i2) {
        List<Integer> output = new ArrayList<>();
        output.add(i1);
        output.add(i2);
        return output;
    }

    class Node {
        public Node[] children = new Node[26];
        public int idx;
        public List<Integer> polindromes = new ArrayList<>();
    }


    
}