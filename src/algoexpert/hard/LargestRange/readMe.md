Largest Range

For this problem we have to find the largest consecutive range of numbers possible in the array. the array does not have to be in order but the values of the range have to all be in the input. The best method to solving this problem is by using a hash map. 

We check to see if hte values of the left and right of the current value is in the hash. if it is, we can increase the length by 1. 

O(n) time | O(n) space