GetYoungestCommonAncestor

For this problem, we traverse the ancester until we find a common ancestor. 

For the first method, we can store the name or the node in a hash set to keep track of the traversed node. If the set includes the node, then we have a common ancestor. 

O(d) time | O(d) space

We can improve the solution by keeping track of the depth of the two nodes and checking at which depth will the nodes be equal. 

 O(d) time | O(1) space