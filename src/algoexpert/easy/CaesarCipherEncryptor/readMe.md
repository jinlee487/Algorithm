CaesarCipherEncryptor

We can use the unicode for the alphabets to solve this question

a => 97 
z => 122

The key input can be more than 26. Therefore we have to consider the edge case where we have to % key by 26 to get the correct change value. 

Then we have to consider the case where the values are moved from z back to a => where we have to % the key by 26 again.

Because we are traversing the values once,
the time complexity would be O(n) and the space complexity would be O(n) as well since we are creating a new array the same size as n