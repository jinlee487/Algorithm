Find Loop

For this problem there are two ways of solving. 

The first method is to use a set to record the visited nodes. 

O(n) time | O(n) space

The improved method is to use the first and second node running ahead.

first = d + p
second = d + 2p + r
loop = d + p + r
answer = d
remaining = first - loop  = r
second loop's location when finishing = r
therefore, 

we can move the first node back to the head. Then we can see when first and second node meets. This is the answer
