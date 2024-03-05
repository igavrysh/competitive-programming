# Change Directory

Given current directory and change directory path, return final path.

For Example:
```
Curent                 Change            Output

/                    /facebook           /facebook
/facebook/anin       ../abc/def          /facebook/abc/def
/facebook/instagram   ../../../../.      /
```

API:

* `pwd(String path)` - initialization function, initializes your current `location` in file system
* `String cd(String path)` - change directory, changes `location` from your current `location`, using relative/absolution `path` specified as parameter


`Hint`

Use stack

Related problems:
* https://leetcode.com/problems/simplify-path/