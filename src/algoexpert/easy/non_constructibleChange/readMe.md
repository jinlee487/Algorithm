We can solve this problem by 
adding up the coins and comparing the current sum to the next coin in the array. 
if the 
```
sum + 1 < coin
```

then we can assume that sum + 1 cannot be made because the next value of the coin is too big and 
it will skip the immediate next couple values.