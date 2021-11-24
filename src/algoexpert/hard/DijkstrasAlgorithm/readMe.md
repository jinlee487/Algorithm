Dijkstras Algorithm

For this problem, we have to go through each node to find the minimum distance it would take to travel and save it into the dp array. 

The time complexity of this problem depends on how we find the next vertex in the edges we are given.

The one detail about this problem that makes it challenging is that the starting vertext is a given and not always a 0. This means that we always have to search for the starting node

The first method, we can simply iterate through the edges until we find the nextNode. 

This would give us complexity of O(v^2 + e) time | O(v) space Where v is the number of vertices and e is the number of edges in the input graph. 

This is because we are looping through the array inside a while loop. 

The improved method is to use a heap data structure. 
This would allow us remove, update at O(1) time and sort at log(n) time

The heap structure is time consuming to make all from scratch. Most interviewer will not expect you to do this since making a heap is an entirely different problem. Just be able to explain that this is possible. 

There is a way to mimic what the heap structure does by using a list and HashMap. 
If we create an Item object with the vertex and distance, we can allow the list and hashMap to share the pointers to the object. 

We can update the vertex constant time using the HashMap.
While we sort the list in log(n) time and pop the last object in constant time.

This would give complexity of O((v+e) * log(v)) | O(v) space Where v is the number of vertices and e is the number of edges in the input graph. 