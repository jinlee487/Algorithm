Min Rewards

For this problem, there are 3 solutions. 

The first solution is a naive solution. We simply loop through the array until we find a value that is decreasing. If it is decreasing, it means that the values before the current has to be +1. We loop back and make the changes. 

O(n^2) time | O(n) space

The improved method has us finding the troughs in the array values. we loop from the trough left and right and +1. 

O(n) time | O(n) space

The best method is to simply loop the array twice left and right. 

O(n) time | O(n) space