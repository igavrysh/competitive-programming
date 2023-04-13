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
        int initialI = hash(key);
        int i = initialI;

        int counter = 1;

        while ((a[i] != null && a[i].key != key) || thumbstone[i] == true) {
            i = nextHash(i);
            counter++;
        }

        if (counter == capacity) {
            throw new RuntimeException("loop in internal array, values overflow");
        }

        thumbstone[i] = false;

        if (a[i] == null) {
            a[i] = new Pair(key, value);
            count++;
        } else {
            a[i].value = value;
        }

        if ((count * 1.0 / capacity) >= LOAD_FACTOR) {
            resize((int)(capacity * RESIZE_MULT));
        }
    }

    public int get(int key) {
        Integer idx = find(key);
        return idx == null ? -1 : a[idx].value;
    }

    private Integer find(int key) {
        int i = hash(key);
        int counter = 0;
        while ((a[i] != null || thumbstone[i] == true) && counter++ < capacity) {
            if (a[i] != null && a[i].key == key) {
                return i;
            }
            i = nextHash(i);
        }
        return null;
    }

    public void remove(int key) {
        Integer idx = find(key);
        if (idx == null) {
            return;
        }

        a[idx] = null;
        count--;

        Integer nextIdx = nextHash(idx);

        if (a[nextIdx] != null || thumbstone[nextIdx] == true) {
            thumbstone[idx] = true;
        } else {
            thumbstone[idx] = false;
        }
         
        if (count * 1.0 / capacity <= LOAD_FACTOR_FLOOR) {
            resize(Math.max(INITIAL_CAPACITY, (int)(capacity / RESIZE_MULT)));
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
