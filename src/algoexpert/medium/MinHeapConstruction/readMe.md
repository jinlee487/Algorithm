Min Heap Construction

For this problem, we have to construct a min heap. 

Min heap has a minimum value of the array as the root. each node has a value smaller than the child node. The heap is not necessarly sorted

current node = i
child one = 2i + 1
child two = 2i + 2
parent node = floor((i-1)/2)

building heap() start from first half of the array and insert sift down. it will automaticall have checked the entire array after finishing the for loop
O(n) time | O(1) space

sift down() compares the current node to the two child nodes. It will take the smaller of the child nodes and keep swapping until it stops 
O(log(n)) time | O(1) space

sift up() 
compares the parent node if it is bigger, it will swap
O(log(n)) time | O(1) space

insert will insert the value to the end of the heap. It will then call sift up()
O(log(n)) time | O(1) space

remove() will swap the root with the last node. then it will pop the original root value. 
Then it will call sift down on the new root value to re heap
O(log(n)) time | O(1) space

peak() will return the first value of the heap
O(1) time | O(1) space

swap() will swap the two indicies. 