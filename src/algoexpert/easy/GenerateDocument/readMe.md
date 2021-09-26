Generate Document

For this problem we have many differennt methods of solving this. 
The first method is simply looping the string over each values to check if there is another the count of the value in the other string. 
This method is O(m * (n+m)) time | O(1) space.

We can improve this method by creating a set. 
This method is O(c * (n+m)) time | O(c) space.
c being the unique values in the input

The best method is to loop only once by using a hash map.
This method is O(n+m) time | O(c) space
