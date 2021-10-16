MaxSubsetSumNoAdjacent

For this problem,

We can use a bottom up dynamic programming tabulation method. 

array[i] is max of either array[i-1] or array[i]+array[i-2] 

O(n) time | O(1) space