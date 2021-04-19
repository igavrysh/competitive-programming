# 41. First Missing Positive
Hard

Given an unsorted integer array nums, find the smallest 
missing positive integer.

Example 1:
```
Input: nums = [1,2,0]
Output: 3
```
Example 2:
```
Input: nums = [3,4,-1,1]
Output: 2
```
Example 3:
```
Input: nums = [7,8,9,11,12]
Output: 1
```
Example 4:
```
Input: nums = [1]
Output: 2
```
Example 5:
```
Input: nums = [0,2,2,1,1]
Output: 3
```
Constraints:
*  0 <= nums.length <= 300
* -2^31 <= nums[i] <= 2^31 - 1

___
**Is it O(N) or O(N^2) time complexity?**

The main question is why even when having ``for(...) { while(...) {...} }`` loops we 
still end up having ``O(N)`` complexity? [@htfy96](https://leetcode.com/htfy96) 
provided good explanation, however for me it is easier to see when checking on sample inputs:

* input = ``[7,6,-1,1,3,4,5]``

| step | i | swaps | output |
| --- | --- | --- | --- |
|0| 0 | no swaps, initial state |``[7,6,-1,1,3,4,5]``|
|1 |0| 7 <-> 5|``[5,6,-1,1,3,4,7]``|
|2|0|5 <-> 3|``[3,6,-1,1,5,4,7]``|
|3|0|3 <-> -1|``[-1,6,3,1,5,4,7]``|
|4|1|6 <-> 4|``[-1,4,3,1,5,6,7]``|
|5|1|4 <-> 1|``[-1,1,3,4,5,6,7]``|
|6|1|-1 <-> 1|``[1,-1,3,4,5,6,7]``|
|7|1|no swaps, -1 is exceptional case|``[1,-1,3,4,5,6,7]``|
|8|2|no swaps, 3 is already on the right place|``[1,-1,3,4,5,6,7]``|
|9|3|no swaps, 4 is already on the right place|``[1,-1,3,4,5,6,7]``|
|10|4|no swaps, 5 is already on the right place|``[1,-1,3,4,5,6,7]``|
|11|5|no swaps, 6 is already on the right place|``[1,-1,3,4,5,6,7]``|
|12|6|no swaps, 7 is already on the right place|``[1,-1,3,4,5,6,7]``|
* **N:** 7
* **Total swaps:** 6
* **Total steps:** 12

**Worst case**

In the worst case scenario we will stay on position ``0``, and swap all elements 
to the ``N-1`` right places. After doing that, next interations for ``i=1...N-1`` 
will not swap any element as all of them has been swaped on the previous iterations 
while staying on ``i=0``. After moving to ``i=1..N`` all elements are already in place. 
Total swaps in this case is ``N-1``. Number of iterations  = # of iter. spent on swaps
when ``i=0`` +  # of iter. spent on ``i=1..N-1`` =  ``N-1 + N-1``.

* input = ``[4,1,2,3]``
```
i:0          i:0          i:0          i:0          i:1                  i:3
[4,1,2,3] -> [3,1,2,4] -> [2,1,3,4] -> [1,2,3,4] -> [1,2,3,4] -> ... -> [1,2,3,4]
```

So the total time complexity of this algorithm in worst case after adding final array scan is = ``N-1 + N-1 + N`` = ``3N``
