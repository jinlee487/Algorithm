Solving the fibonacci problem requires either the two steps. 

top down or bottom up apprach. 

the top down approach is typically a recursive procedure where I call upon the funciton until we get to a n = 1 or n = 2. 

This would give us a time complexity of O(n^2) and o(n) space complexity which we would not want. 

we can memoize the values by storing them in hash or arrays. This way, after we are done calculating, we can look up other results that are smaller than n

this would give us a time complexity of O(n) and space complexity of O(n)

the bottom up apprach can be done in many different ways. 

We can make the solution even simpler by just using a iterative solution. 
This would give us a time complexity of O(n) and space complexity of O(1) since we are not creating any new arrays. 