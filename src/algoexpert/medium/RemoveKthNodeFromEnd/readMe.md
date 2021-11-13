Remove Kth Node From End

For this problem, there is the iteration method and the recursive method. 

The recursive method simply travels the nodes until it finds the last node. It returns a count + 1. 
Once we find a return value matching our k, we remove the node. 

The iterative method makes finds a node that is k away from the root. Then it has a second loop will move both the root and the new node until the new node is at the end. the second node which was at root is now at the kth from the end. 

O(n) time | O(1) space

Both have same complexity but iterative method does perform less computations