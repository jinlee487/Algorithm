BstConstruction

For this problem, 

We have to construct the class for Binary Search Tree. 

The insert method

The value will be compared to the current value and if the is smaller, we have to look at the left side of the branch or if it bigger, the right side. we repeat until there is not a left or a right branch and insert the new node

The contains method

This is similar to the insert method.
We compare until we find the value and return true

The remove method. 

This is tricky to do due to the edge cases. We want to find traverse and find the left most node on the right side of the root. This will ensure that the value is going to be inbetween the left and right node values from the root. 

We find the value and put the value in the root. However, if there is a case where the smallest value has a right side branch, then we cannot remove that node. We have to call the remove function as that current node as the root to get this node removed. 
At average, the time complexity will be O(log(n)) and space complexity of O(n) for recursive and O(1) for iterative

At worst, the time complexity will be O(n) . 
