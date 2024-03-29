import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class MyHashMapArrayOfLists {

    private static double LOAD_FACTOR = 0.75;
    private static double LOAD_FACTOR_FLOOR = 0.1;
    private static int INITIAL_CAPACITY = 16;

    private int capacity = INITIAL_CAPACITY;
    private int count = 0;
    private List<Pair>[] buckets = new List[capacity];

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
                break;
            }
        }

        if (!inserted) {
            l.add(new Pair(key, value));
            count++;
        }

        buckets[hash] = l;

        if (count/capacity > LOAD_FACTOR) {
            resizeBuckets(capacity*2);
        }
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

        if (count/capacity < LOAD_FACTOR_FLOOR) {
            resizeBuckets(Math.max(INITIAL_CAPACITY, capacity / 2));
        }
    }

    private void resizeBuckets(int newCapacity) {
        if (capacity == newCapacity) {
            return;
        }
        List<Pair>[] b = new List[newCapacity];
        for (int i = 0; i < capacity; i++) {
            if (buckets[i] != null) {
                for (Pair p : buckets[i]) {
                    int newHash = hash(p.key, newCapacity);
                    if (b[newHash] == null) {
                        b[newHash] = new LinkedList<Pair>();
                    }
                    b[newHash].add(p);
                }
            }
        }
        buckets = b;
        capacity = newCapacity;
    }

    private int hash(int key, int capacity) {
        return key % capacity;
    }

    private int hash(int key) {
        return hash(key, this.capacity);
    }
}