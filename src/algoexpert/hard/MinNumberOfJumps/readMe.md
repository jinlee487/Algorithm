Min Number Of Jumps

For this problem,

There are two solutions. 

The first solution is to iterate the array and record the minimum steps it takes to get to the next step from our current index on the next destination. This method however is unsuited for this problem because there is no limit of how big the max number of steps you can take is. 

A fix to this is to simply in the inner loop, iterate from the beggining and compare if the curretn index can be reached from the inner loop location. If it can, we can update the value. 

This method will be O(n^2) time | O(n) space

The improved solution would be to iterate only once and record the maximum reach it can reach from the current location. we can continually move along until we run out of steps we can take - then we can update how much more steps we can take with the current maximum reach. Each time this takes place, we will have taken a step.

O(n) time | O(1) space