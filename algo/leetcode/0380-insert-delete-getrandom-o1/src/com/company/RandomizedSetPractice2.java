package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomizedSetPractice2 {

    private MyHashMap map = new MyHashMap();
    private List<Integer> a = new ArrayList<>();
    private Random random = new Random();
    
    public RandomizedSetPractice2() {}
    
    public boolean insert(int val) {
        if (map.get(val) != null) {
            return false;
        }
        a.add(val);
        map.put(val, a.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        Integer idx = map.get(val);
        if (idx == null) {
            return false;
        }

        Integer valToMove = a.get(a.size()-1);

        a.set(idx, valToMove);
        map.put(valToMove, idx);

        a.remove(a.size()-1);
        map.remove(val);

        return true;
    }
    
    public int getRandom() {
        if (a.size() == 0) {
            throw new RuntimeException("no elements in set");
        }
        int idx = random.nextInt(a.size());
        return a.get(idx);
    }
}

class MyHashMap {

    private static double LOAD_FACTOR = 0.75;
    private static double LOAD_FACTOR_FLOOR = 0.1;
    private static int INITIAL_CAPACITY = 16;

    private int capacity = INITIAL_CAPACITY;
    private int count = 0;
    private List<Pair>[] buckets = new LinkedList[capacity];

    class Pair {
        public int key;
        public int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
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

    public Integer get(int key) {
        int hash = hash(key);
        List<Pair> l = buckets[hash];
        if (l == null) {
            return null;
        }

        for (Pair p : l) { 
            if (p.key == key) {
                return p.value;
            }
        }

        return null;
    }
    
    public Integer remove(int key) {
        int hash = hash(key);
        List<Pair> l = buckets[hash];
        if (l == null) {
            return null;
        }
        Pair removedPair = null;

        Iterator<Pair> each = l.iterator();
        while (each.hasNext()) {
            Pair nextPair = each.next();
            if (nextPair.key == key) {
                removedPair = nextPair;
                each.remove();
                count--;
                break;
            }
        }

        if (count/capacity < LOAD_FACTOR_FLOOR) {
            resizeBuckets(Math.max(INITIAL_CAPACITY, capacity / 2));
        }

        return removedPair.value;
    }

    private void resizeBuckets(int newCapacity) {
        if (capacity == newCapacity) {
            return;
        }
        List<Pair>[] b = new LinkedList[newCapacity];
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
