ReconstructBst

For this problem, 

We have to reconstruct a BST from a given array in the pre order of the tree itself. 

The first option, we can simply loop to find the right side of the tree and we can make a sub tree of the left and right from the root and repeat the process.

This would give a time complexity of O(n^2) and space complexity of O(n)

The second option which is optimized is a better solution. By going through and comparing the upper and lower bound for each of the values in the array, we do not have to perform loops to find subtrees. 

This would give a time complexity of O(n) and space complexity of O(n)


