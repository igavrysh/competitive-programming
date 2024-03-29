package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomizedSet {

    public class Element {
        public Integer value;
        public Integer indexInList;

        public Element(Integer value, Integer indexInList) {
            this.value = value;
            this.indexInList = indexInList;
        }
    }

    public HashMap<Integer, Element> map;
    public List<Integer> list;
    public Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    private Element get(int val) {
        return map.get(val);
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
        Element el = get(val);
        if (el != null) {
            return false;
        }
        map.put(val, new Element(val, list.size()));
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        Element e = get(val);
        if (e != null) {
            Element lastElement = map.get(list.get(list.size() - 1));
            Collections.swap(list, e.indexInList, lastElement.indexInList);
            lastElement.indexInList = e.indexInList;
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (list.size() == 0) {
            return -1;
        }
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}
