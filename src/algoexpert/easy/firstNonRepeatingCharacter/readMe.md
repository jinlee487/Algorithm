firstNonRepeatingCharacter

For this problem,

We can do a double loop to find the first non repeating letter. 
This would give us a O(n^2) time | O(1) space.

We can improve this by using a hash map to find the non repeating value with less complexity. 

This would give us O(n) time | O(1) space. 

THis is because the max size of the hash map will be 26 since there are 26 characters possible in the input. 