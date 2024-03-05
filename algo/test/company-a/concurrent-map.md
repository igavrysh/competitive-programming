# Concurrent Map

Create a data structure that can support concurent acccess to its data

Data structure should support any Object type as a key & any Object type as a value 

 * Memory usage should be efficient
 * Data structure should be perfomant
 * Use patterns: 90% of keys have 1 value, remainig 10% of keys have 2+ values
  
The following API should be supported:

* `add(key, value)` adds value to the the key
* `get(key)` returns collection of stored values for the passed key
* `contains(key)` returns true/false and checks if the key is contained in data structure

Example of usage:

```
add("hello", "world"); 
add("hello", "folks");
contains("hello") -> true;
contains("buy") -> false
get("hello") -> ["world", "folks"]
```

one of the solutions: use `ConcurrentHashMap<K, ArrayList<V>>` + atomic non blocking api for it