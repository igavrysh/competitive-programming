public class MyHashMapArray {

    private static double LOAD_FACTOR = 0.5;
    private static double LOAD_FACTOR_FLOOR = 0.25;
    private static double RESIZE_MULT = 2.0;
    private static int INITIAL_CAPACITY = 16;

    private int capacity = INITIAL_CAPACITY;
    private int count = 0;
    private Pair[] a;
    protected boolean[] thumbstone;

    class Pair {
        public int key;
        public int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMapArray() {
        a = new Pair[capacity];
        thumbstone = new boolean[capacity];
    }

    public MyHashMapArray(int capacity) {
        this.capacity = capacity;
        a = new Pair[this.capacity];
        thumbstone = new boolean[capacity];
    }

    public void put(int key, int value) {
        int hashKey = hash(key);
        int idx = hashKey;

        int counter = 1;

        while (((a[idx] != null && a[idx].key != key) || thumbstone[idx] == true) && counter < capacity) {
            idx = nextHash(idx);
            counter++;
        }

        if (counter == capacity) {
            throw new RuntimeException("loop in internal array, values overflow");
        }

        thumbstone[idx] = false;

        if (a[idx] == null) {
            a[idx] = new Pair(key, value);
            count++;
        } else {
            a[idx].value = value;
        }

        if ((count * 1.0 / capacity) >= LOAD_FACTOR) {
            resize((int)(capacity * RESIZE_MULT));
        }
    }

    private void resize(int newCapacity) {
        if (capacity == newCapacity) {
            return;
        }
        
        MyHashMapArray tmp = new MyHashMapArray(newCapacity);

        for (int i = 0; i < capacity; i++) {
            if (a[i] != null) {
                tmp.put(a[i].key, a[i].value);
            }
        }

        this.a = tmp.a;
        this.thumbstone = tmp.thumbstone;
        this.capacity = tmp.capacity;
        this.count = tmp.count;
    }

    public int get(int key) {
        int i = hash(key);
        while ((a[i] != null && a[i].key != key) || thumbstone[i] == true) {
            i = nextHash(i);
        }
        return a[i] == null || a[i].key != key ? -1 : a[i].value;
    }

    public void remove(int key) {
        int hashKey = hash(key);
        int i = hash(key);

        while ((a[i] != null && a[i].key != key) || thumbstone[i] == true) {
            i = nextHash(i);
        }

        if (a[i] == null) {
            return;
        }

        thumbstone[i] = true;
        a[i] = null;
        count--;
        
         
        if (count * 1.0 / capacity <= LOAD_FACTOR_FLOOR) {
            resize(Math.max(INITIAL_CAPACITY, (int)(capacity / RESIZE_MULT)));
        }
    }

    protected int hash(int key, int capacity) {
        return key % capacity;
    }

    protected int hash(int key) {
        return hash(key, this.capacity);
    }

    protected int nextHash(int hash) {
        return nextHash(hash, this.capacity);
    }
    
    protected int nextHash(int hash, int capacity) {
        return (hash+1)%capacity;
    }
}
