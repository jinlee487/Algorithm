To solve this problem, we create a depth first searc recursive operation. 
we travel through the children to their child nodes starting from te given root. 

In the sample, we start from A and go to B and to B's child. 

The time complexity is O(v+e) 
v = number of verticies 
e = number of edges

At every vertext, we call for another for loop fuction however many children nodes we have. 

space complexity is O(v).

we traverse as many vertex there is. 