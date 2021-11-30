Shifted Binary Search

For this probelm,

There are 3 solutions.

The first solution is to find the minimum value index of the array and use that as the index 0 while performing normal binary search operations.

O(n+log(n)) time | O(1) space

The second solution is to add more compare cases to check how the boundaries should change.
Recursive solution would be 
O(log(n)) time | O(log(n)) space

The third solution is to perform the second solution in iterative fashion.
O(log(n)) time | O(1) space
