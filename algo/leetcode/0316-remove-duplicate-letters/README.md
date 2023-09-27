### 316. Remove Duplicate Letters

https://leetcode.com/problems/remove-duplicate-letters

`Medium`
7.9K
523
Companies

Given a string `s``, remove duplicate letters so that every letter appears once and only once. You must make sure your result is 
the smallest in lexicographical order
 among all possible results.

 
**Example 1**:
```
Input: s = "bcabc"
Output: "abc"
```

**Example 2**:
```
Input: s = "cbacdcbc"
Output: "acdb"
```

**Constraints**:

* `1 <= s.length <= 10^4`
* `s` consists of lowercase English letters.
 

Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
0 1 2 3 4
b c a b c

lastIdx
b: 3
c: 4
a: 2

0: S = [(b,0)]  -> b is not in stack -> adding, neigh are ok
1: S = [(b,0), (c,1)] c is not in a stack -> ading, neighb are ok
2: S = [(b,0), (c,1)] a? -> a is not in a stack adding, neighb are NOT ok
    a not in stack:
        a < c => need to remove c if its idx != last idx of c
        [(b, 0)] a?
        a < b => need to remove b if its idx != last idx of b
        [] a? => no action req, adding a => [(a,2)]
3: S = [(a,2)] b? b is not in stack, should add, neighb are ok => [(a,2), (b, 3)]
4: S =  [(a,2), (b, 3)], c? c is not in stack, should add, neight are ok (e.g. b < c) => [(a,2), (b, 3), (c, 4)]

go thru stack and add chars backwards