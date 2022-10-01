package com.company;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionBT {
    public List<Integer> grayCode(int n) {
        return helper(0, n, 0, new LinkedHashSet<>() {{ add(0);}});
    }

    private List<Integer> helper(int curr, int n, int depth, LinkedHashSet<Integer> path) {
        if (path.size() == Math.pow(2, n)) {
            return path.stream().collect(Collectors.toList());
        }

        if (depth > Math.pow(2, n)) {
            return null;
        }

        for (int i = 0; i < n; i++) {
            int next = curr ^ (1 << i) ;
            if (!path.contains(next)) {
                LinkedHashSet<Integer> newPath = new LinkedHashSet<>(path);
                newPath.add(next);
                List<Integer> res = helper(next, n, depth+1, newPath);
                if (res != null) {
                    return res;
                }
            }
        }

        return null;
    }
}

// 00 1
