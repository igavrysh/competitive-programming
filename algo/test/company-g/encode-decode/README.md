# Task 3
### Part 1
You are given array of integers

Your task is to write `encode` function that s going to encode array into pairs: `[(value, fq)]`, where `value` is a number from input array, and `fq` - as number of consecutive repeats of value in original array

**Example**
```
input:
a = [1,1,1,2,1,2,3,3,3,3,4,4,1,-1]
output: 
pairs = [[1:3],[2:1],[1:1],[2:1],[3:4],[4:2],[1:1],[-1:1]]
```

API:
```
encode(a: [int]) -> [[int: int]]
```

### Part 2

Write `value_for_idx` & `values_for_idxs` that s going to return the actual value from input array based on passed index in original array & pairs - array of `[value: fq]` `pairs`

```
value_for_idx(idx: int, pairs: [[int: int]]) -> int
values_for_idxs(idxs: [int], pairs: [[int: int]]) -> [int]
```