Get Lowest Common Manager

For this problem, we can solve it the naive method where we simply find each of the nodes and save the path in an array.

We can then follow the array up by depth until we find a match.

O(n+common-shortestDepth) time | O(d) space

The improved solution, we can check if the node has the target and return the count of the targets in the node. If it returns 2, we know that this is the lowest common.
O(n) time | O(d) space