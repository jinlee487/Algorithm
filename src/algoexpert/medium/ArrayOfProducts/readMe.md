ArrayOfProducts

For this problem, we have couple solutions. We can solve it the brute force way, which would be time O(n^2) and space O(n). This would double loop through each of the values to find the product with out the current value index. 

The second way would be to count the zeroes while getting the product of the values excluding the zeroes. Then when we loop the array the second time, we replace the values of the array with the product divided by the current value. With the count of zeroes is more than 0, then we input the values accordingly to produce the correct result. This will give time complextiy of O(n) and space complexity of O(1) 

The third way is by creating another array to record all of the left side products of the given indexes. We then loop in a reverse direction and get the products to insert into the answer array. This will give time complextiy of O(n) and space complexity of O(n) 



