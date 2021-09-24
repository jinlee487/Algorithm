For this problem, we can do recursive or iterative approach.

For binary Search, we have a sorted list. We need to check if the mid value is bigger or smaller than the target. Afterwards, we choose the top or the bottom array to search. Hence the reason why it is binary. 

The recursive method has a time complexity of O(log(n)) and space complexity of O(log(n)). 

because we search the array but we dont have to search the entire array. We also have to use more arrays to search. 

The recursive method has a time complexity of O(log(n)) but a space complexity of O(1). 

This is because we are not creating a new array, we are merely changing the left right values. 