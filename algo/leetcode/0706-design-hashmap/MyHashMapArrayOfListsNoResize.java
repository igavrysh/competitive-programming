import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

public class MyHashMapArrayOfListsNoResize {
    
    int capacity = 2048;

    int count = 0;

    List<Pair>[] buckets = new List[capacity];

    class Pair {
        public int key;
        public int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMapArrayOfListsNoResize() {
    }
    
    public void put(int key, int value) {
        int hash = hash(key);
        List<Pair> l = buckets[hash];
        if (l == null) {
            l = new LinkedList<>();
        }

        boolean inserted = false;
        for (Pair p : l) {
            if (p.key == key) {
                p.value = value;
                inserted = true;
            }
        }

        if (!inserted) {
            l.add(new Pair(key, value));
            count++;
        }

        buckets[hash] = l;
    }
    
    public int get(int key) {
        int hash = hash(key);
        List<Pair> l = buckets[hash];
        if (l == null) {
            return -1;
        }

        for (Pair p : l) { 
            if (p.key == key) {
                return p.value;
            }
        }

        return -1;
    }
    
    public void remove(int key) {
        int hash = hash(key);
        List<Pair> l = buckets[hash];
        if (l == null) {
            return;
        }

        Iterator<Pair> each = l.iterator();
        while (each.hasNext()) {
            if (each.next().key == key) {
                each.remove();
                count--;
                break;
            }
        }
    }

    private int hash(int key, int capacity) {
        return key % capacity;
    }

    private int hash(int key) {
        return hash(key, this.capacity);
    }
}