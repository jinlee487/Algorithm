Linked List Construction

For this problem,

we have to create a linked list. 

To do this, we have to think about how the linked list behaves. 

1. setHead() has to take into the edge case where there is no head node. This means that the linked list is empty
2. setTail() has to take into the edge case where there is no tail node. This means that the linked list is empty. We redirect the function to setHead()
3. insertBefore() has to take into the case where the node being inserted is already in the linked list and the linked list size is 1. In this case, we return because no change needs to occur.
If the current node is a head, then we must make the inserted a head
4. insertAfter() has to take into the case where the node being inserted is already in the linked list and the linked list size is 1. In this case, we return because no change needs to occur. If the current node is a tail, then we must make the inserted a tail.
5. insertAtPosition() has to take into account if the position is 1 => the node being inserted becomes the head.
if the node being inserted position is bigger than the size of the linked list, we can make the inserted node a tail.
6. removing node with value can be done iteratively going through the linked list and finiding nodes with the same value and passing them through the remove(). If no matching values, nothing will happen to them.
7. remove() will check if the node is a head or tail. If it is, we have to make the nearest connecting node the new head or tail.
We pass the node to removeNodeBindings to delete the node.
8. containtsNodeWithValue() simply iterates through the node until it finds a node with the value. 
9. removeNodeBindings will connect the node before and after together. 