import java.util.ArrayList;
import java.util.List;

class MyHashMapArrayOfLists {

    private static double LOAD_FACTOR = 0.5;

    int capacity = 10;

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

    public MyHashMapArrayOfLists() {
    }
    
    public void put(int key, int value) {
        if (count / capacity > LOAD_FACTOR) {
            resizeBuckets(capacity*2);
        }

        int hash = hash(key);
        List<Pair> l = buckets[hash];
        if (l == null) {
            l = new ArrayList<>();
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

    private void resizeBuckets(int newCapacity) {
        List<Pair>[] b = new List[newCapacity];
        for (int i = 0; i < capacity; i++) {
            if (buckets[i] != null) {
                for (Pair p : buckets[i]) {
                    int newHash = hash(p.key, newCapacity);
                    if (b[newHash] == null) {
                        b[newHash] = new ArrayList<Pair>();
                    }
                    b[newHash].add(p);
                }
            }
        }
        buckets = b;
        capacity = newCapacity;
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
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).key == key) {
                l.remove(i);
                count--;
                break;
            }
        }

        if (count/capacity < LOAD_FACTOR / 2.0) {
            resizeBuckets(Math.max(10, capacity / 2));
        }
    }

    private int hash(int key, int capacity) {
        return key % capacity;
    }

    private int hash(int key) {
        return hash(key, this.capacity);
    }
}