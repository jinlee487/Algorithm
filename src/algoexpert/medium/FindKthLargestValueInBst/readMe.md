FindKthLargestValueInBst

For this problem, there is two methods. 

The first method is traversing all the nodes and getting the kth node in the array
This would give a time complexity of O(n) and space complexity of O(n)

The second improved method is traversing the array and returning when the count matches k.
This would give a time complexity of O(h+k) and space complexity of O(h) where h is the height of the tree. 

