FindSuccessor

For this problem, we have two solutions. 

The first solution is simply traversing through all the nodes and creating an ordered array. We then get the next node from the give node.

O(n) time | O(n) space

We can improve this by simply ignoring the given tree and focusing on the given node. 
If there is a right node, then the answer has to be a right node or the parent. 
if there is not a right node. then the answer has to be a left node or parent. 
we can use this rule to find the node without traversing through all the tree node. 
However we can only use this if the parent node is included in the binary tree class. 

O(h) time | o(1) space where h is height