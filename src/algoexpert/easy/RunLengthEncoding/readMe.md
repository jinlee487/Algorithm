RunLengthEncoding

For this problem,

We have to compare the current to the previous value and if the value is different, we add the count and the value to the string builder. 

Due to the edge case where the input is an empty string, we can add the last value outside of the forloop to consider the edge case. 

This is O(n) time since we are only viewing the value once, and O(n) space because we are creating a string builder with the length determined by the string.
