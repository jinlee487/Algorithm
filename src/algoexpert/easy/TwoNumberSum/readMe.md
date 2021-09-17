```
[3,5,-4,8,11,-1,6]
find two numbers that sums to 10
[11,-1]
```

1. two for loops. 
    not very optimal from time point of view o^2
2. hash table 
    traverse array and store numbers in hash table. We can then access them in real time O^1
    Python dictionary, JavaScript Object or Java HashMap

    target sum = 10
    current num = x
    x + y = 10
    y = 10 - x 

    Apply this formula to solve this problem. 

    If y is in the hash table, we just return x and y otherwise, we keep traversing the array and adding x to the hash table. 

    This way we can add numbers to the hash table and check for the sum at the same time which reduces our loop to a sinlge loop