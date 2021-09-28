ThreeNumberSum

For this problem, we have to loop the array twice. We first loop through the array and find the targetSum - current value. This result of this is the two number sum we have to find. Now when we loop the array the second time, we can either loop it twice which would give us O(N^2log(n)) time or we can use binary search which would give us O(n^2) which is not as bad. 

The space complexity of this would be O(n) since the array answer will be accordance to how ever long the given array will be 