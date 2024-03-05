# Add/Remove/RemoveRandom in O(1)

Create a data structure that supports following Api with `O(1)` time complexity

* `void add(int val)`, adds element to the data structure
* `void remove(int val)`, removes element from the data structure
* `int removeRandom()`, removes and returns random element from the data structure

`Hint`

Use `ArrayList`, but with support `O(1)` remove random: 
1. select random value 
1. swap random value with last element 
1. shrink `ArrayList` by 1 element
Shrinking `ArrayList` by 1 element ammortized time complexity is `O(1)`, as it only moves elements into new array with `O(N)` time complexity in case when `size` becomes 1/4 of `capacity`. In this case shrink array by half.