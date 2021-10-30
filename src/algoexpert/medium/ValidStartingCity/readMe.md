ValidStartingCity

For this problem

we can use the brute force method to see if every start of the cities works. 
O(n^2) time | O(1) space

The improved method is a greedy algorithm. Since we know that as long as the distance possible for travel at a certain city is greater than the minimum miles we cannot travel, then that city is returned as the answer.
O(n) time | O(1) space