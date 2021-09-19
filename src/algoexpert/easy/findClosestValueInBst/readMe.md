To solve this problem, we have to go through the nodes of the tree. 
To traverse the tree, we have to identify how the tree is structured. 

If we look at the BST class, we find that it is a class of BST inside of a class of BST. 

We can see if the absolute value of the value subtracted by the target ismaller in comparason to our closest value we have found so far. 

And repeat the process until we finish traversing the tree.

If our target value is bigger than the current node's value, there is no reason to traverse into the side of the tree where the value of the node is even smaller than the currentNode because the difference to the target value will be even bigger. 

This way we can eliminate unessessary computation. 