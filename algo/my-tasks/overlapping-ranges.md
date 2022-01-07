
## Overlapping ranges

You are given array string expression with conditions for variables ('A'-'Z') ranges. Expression might include brackets, and signs `+`, `-`. E.g.
```
A > 10 AND B < 11 OR (C >= -4 OR -5 < B) OR A
```
Return non-overelapping ranges for every variable in format 
```
A: [10,+Inf]
B: [-5,11]
C: [-4,+Inf]


