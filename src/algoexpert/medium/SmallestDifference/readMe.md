SmallestDifference

For this problem, we have two choices. 

We can loop the two arrays in a O(n^2) time | O(1) space and get the minimum total two values. However, this method traveres through all the values which is inefficient. 

The better method is to sort both of the arrays and then use indexes to traverse the arrays and moving the index only when we find values that are smaller than the other. This would give us O(nlog(n) + mlog(m)) time | O(1) space. 
