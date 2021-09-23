For this problem, we have to find out if either of the arrays after being ordered, all the values in that ordered array should be bigger than the values in the other ordered array. 
To solve this problem, we must first sort each of the array, then compare the values one by one. 
This will result in a O(nlog(n)) time because sorting takes nlog(n) time max. 
and O(1) since we are calling by the index therefore constant time. 