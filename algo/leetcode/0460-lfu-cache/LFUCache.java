import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
    public static class Node {
        int fq;
        boolean isSentinel;
        public Node next;
        public Node prev;
        public LinkedHashSet<Integer> keys = new LinkedHashSet<>();
        public Node() {
            this.isSentinel = true;
        }
        public Node(int key, int fq) {
            this.fq = fq;
            this.isSentinel = false;
            this.keys.add(key);
        }
    }

    HashMap<Integer, Integer> data = new HashMap<>();
    HashMap<Integer, Node> nodes = new HashMap<>();
    Node head, tail;
    int capacity;

    public LFUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    private int _size() {
        return this.data.keySet().size();
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        
        if (nodes.get(key) != null) {
            Node n = nodes.get(key);
            int fq = n.fq + 1;
            _delete(key);
            Node curr = n.next;
            Node nn = _put(key, fq, curr);
            nodes.put(key, nn);
            data.put(key, value);
        } else {
            if (this._size() == capacity) {
                int keyToDel = head.next.keys.iterator().next();
                this._delete(keyToDel);
                nodes.remove(keyToDel);
                data.remove(keyToDel);
            }
            Node nn = _put(key, 1, head.next);
            nodes.put(key, nn);
            data.put(key, value);
        }
    }

    public int get(int key) {
        if (data.get(key) == null) {
            return -1;
        }

        Node n = nodes.get(key);
        int fq = n.fq + 1;
        _delete(key);
        Node curr = n.next;
        Node nn = _put(key, fq, curr);
        nodes.put(key, nn);
        return data.get(key);
    }

    public void delete(int key) {
        if (nodes.get(key) == null) {
            return;
        }
        _delete(key);
        nodes.remove(key);
        data.remove(key);
    }

    void _delete(int key) {
        if (nodes.get(key) == null) {
            return;
        }
        Node n = nodes.get(key);
        n.keys.remove(key);
        if (n.keys.size() == 0) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
    }

    Node _put(int key, int fq, Node curr) {
        while (!curr.isSentinel && curr.fq < fq) {
            curr = curr.next;
        }

        if (curr.isSentinel || curr.fq != fq) {
            Node newNode = new Node(key, fq);
            Node currPrev = curr.prev;

            curr.prev = newNode;
            newNode.next = curr;

            currPrev.next = newNode;
            newNode.prev = currPrev;

            curr = newNode;
        } else {
            curr.keys.add(key);
        }

        return curr;
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        boolean passed = true;
        LFUCache cache = new LFUCache(2);
        cache.put(2,1);
        cache.put(3,2);
        passed &= (cache.get(3) == 2);
        passed &= cache.get(2) == 1;
        cache.put(4, 3);
        passed &= cache.get(2) == 1;
        passed &= cache.get(3) == -1;
        passed &= cache.get(4) == 3;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    /*
["LFUCache","put","put","get","get","put","get","get","get"]
[[2],       [2,1],[3,2],[3],  [2],  [4,3],[2],  [3],  [4]]
[null,      null,   null,2,   1,    null, 1,    -1,    3]
     */
}
