```
[5,1,22,25,6,-1,8,10]

check if the given sequence is a subsequence of the first sequence. 

[1,6,-1,10]

```

Subsequence means that the numbers on the sequence are given in the same order of the first sequence, but does not have to be the exact same. 

We can solve this problem using a O(n) time. n being the length of the given sequence. 

We simply loop through the first array while checking with a pointer indexed to the number in the subsequence. When we find a matching number, we add + 1 to the pointer. 

When we have finished the loop, the pointer value should be the same as the size of the subsequence array. 

If not, then it must mean the subsequence was not a subsequence after all. 



