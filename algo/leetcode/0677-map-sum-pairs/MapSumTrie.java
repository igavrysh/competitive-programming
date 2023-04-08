import java.util.HashMap;

class MapSumTrie {

    private TrieNode root = new TrieNode();
    private HashMap<String, Integer> map = new HashMap<>();

    public MapSumTrie() {
    }
    
    public void insert(String key, int val) {
        int delta = -map.getOrDefault(key, 0) + val;
        map.put(key, val);

        char[] chrs = key.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chrs.length; i++) {
            if (node.children[chrs[i]-'a'] == null) {
                TrieNode newNode = new TrieNode(val);
                node.children[chrs[i]-'a'] = newNode;
                node = newNode;
            } else {
                node = node.children[chrs[i]-'a'];
                node.val += delta;
            }
        }
    }
    
    public int sum(String prefix) {
        char[] chrs = prefix.toCharArray();
        TrieNode node = root;
        int output = 0; 
        for (int i = 0; i < chrs.length; i++) {
            node = node.children[chrs[i]-'a'];
            if (node == null) {
                output = 0;
                break;
            }
            output = node.val;
        }
        return output;
    }

    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public int val;
        
        public TrieNode(int val) {
            this.val = val;
        }

        public TrieNode() {
        }
    }
}