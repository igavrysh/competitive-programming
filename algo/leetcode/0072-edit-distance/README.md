# 72. Edit Distance
Hard

Given two strings `word1` and `word2`, return the minimum number of operations required 
to convert `word1` to `word2`.

You have the following three operations permitted on a word:

* Insert a character
  
* Delete a character
  
* Replace a character

Example 1:
```
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
```
Example 2:
```
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
```


Constraints:

* `0 <= word1.length, word2.length <= 500`

* `word1` and `word2` consist of lowercase English letters.

**P.S.** 

I was struggling understanding solutions provided in leetcode discussions tab and in separate 
youtube channels, that were recommended ([link1](https://www.youtube.com/watch?v=MiqoA-yF-0M), 
[link2](https://www.youtube.com/watch?v=Xxx0b7djCrs), 
[link3](https://www.youtube.com/watch?v=We3YDTzNXEk))

This video [MIT 6.006 Introduction to Algorithms, Fall 2011 Lectur: 21. DP III: Parenthesization, Edit Distance, Knapsack](https://www.youtube.com/watch?v=ocZMDMZwhCY) 

helped me understand general approach and after watching and internalizing topics discussed in a 
video I was able intuitively understand and come up with solution for this problem.
