package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Util {
    public static Function<Integer[][], List<List<Integer>>> arr2ToLst2 = (a) -> 
        Arrays.asList(a).stream().map(Arrays::asList).collect(Collectors.toCollection(ArrayList::new));

    public static Function<List<List<Integer>>, HashSet<HashSet<Integer>>> lst2ToSet2 = (l) -> 
        l.stream().map(HashSet::new) .collect(Collectors.toCollection(HashSet::new));

}
